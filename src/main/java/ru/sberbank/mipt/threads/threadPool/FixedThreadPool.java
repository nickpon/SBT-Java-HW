package ru.sberbank.mipt.threads.threadPool;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class FixedThreadPool implements ThreadPool {
    private ArrayDeque<Runnable> tasks = new ArrayDeque<>();
    private Object mutex = new Object();
    private ArrayList<Thread> threads;

    public FixedThreadPool(int threadCount) {
        threads = new ArrayList<>(threadCount);
        for (int numOfThread = 0; numOfThread < threadCount; ++numOfThread) {
            threads.add(new MyFixedThread(tasks, mutex));
        }
    }

    @Override
    public void start() {
        for (int i = 0; i < threads.size(); ++i) {
            threads.get(i).start();
        }
    }

    @Override
    public void execute(Runnable task) {
        synchronized (mutex) {
            try {
                tasks.addLast(task);
            } catch (RuntimeException e) {
                throw new RuntimeException("The error has occurred in execute()");
            }
            mutex.notifyAll();
        }
    }
}