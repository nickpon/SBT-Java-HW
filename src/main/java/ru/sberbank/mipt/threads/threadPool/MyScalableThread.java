package ru.sberbank.mipt.threads.threadPool;

import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class MyScalableThread extends Thread {
    private final ArrayDeque<Runnable> tasks;
    private final Object mutex;
    private volatile AtomicInteger currentWorkingThreads;
    private Runnable task;
    private boolean created;

    public MyScalableThread(ArrayDeque<Runnable> tasks, Object mutex, AtomicInteger currentWorkingThreads, boolean created) {
        // Сopying links, not values.
        this.tasks = tasks;
        this.mutex = mutex;
        this.currentWorkingThreads = currentWorkingThreads;
        this.created = created;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (mutex) {
                while (tasks.isEmpty()) {
                    try {
                        mutex.wait();
                    } catch (InterruptedException e) {
                        // For beautiful output.
                        System.err.println("Thread " +
                                Thread.currentThread().getName() + " has been interrupted.");
//                        throw new RuntimeException("The error has occurred in thread " +
//                                Thread.currentThread().getName() + " : ", e);
                    }

                }
                task = tasks.pop();
            }
            makeAction(task, created);
        }

    }

    private synchronized void makeAction(Runnable task, boolean created) {
        task.run();
        if (created) {
            currentWorkingThreads.getAndDecrement();
            Thread.currentThread().interrupt();
        }
    }
}
