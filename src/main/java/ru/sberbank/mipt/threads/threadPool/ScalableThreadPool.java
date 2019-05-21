package ru.sberbank.mipt.threads.threadPool;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ScalableThreadPool implements ThreadPool {
    private ArrayDeque<Runnable> tasks = new ArrayDeque<>();
    private Object mutex = new Object();
    private ArrayList<Thread> threads;
    private int minThreads;
    private int maxThreads;
    private volatile AtomicInteger currentWorkingThreads;

    public ScalableThreadPool(int min, int max) {
        minThreads = min;
        maxThreads = max;
        threads = new ArrayList<>(minThreads);
        for (int numOfThread = 0; numOfThread < minThreads; ++numOfThread) {
            threads.add(new MyScalableThread(tasks, mutex, currentWorkingThreads, false));
        }
        currentWorkingThreads = new AtomicInteger(minThreads);
    }

    @Override
    public void start() {
        for (int i = 0; i < minThreads; ++i) {
            threads.get(i).start();
        }
    }

    @Override
    public void execute(Runnable task) {
        Thread newThread = null;
        synchronized (mutex) {
            try {
                tasks.addLast(task);
                if ((currentWorkingThreads.get() >= minThreads) && (currentWorkingThreads.get() < maxThreads)) {
                    currentWorkingThreads.incrementAndGet();
                    newThread = new MyScalableThread(tasks, mutex, currentWorkingThreads, true);
                } else {
                    mutex.notify();
                }
            } catch (RuntimeException e) {
                throw new RuntimeException("The error has occurred in execute()");
            }
        }

        if (newThread != null) {
            newThread.start();
        }
    }
}