package ru.sberbank.mipt.threads.threadPool;

import java.util.ArrayDeque;

public class MyFixedThread extends Thread {
    private final ArrayDeque<Runnable> tasks;
    private final Object mutex;
    private Runnable task;

    public MyFixedThread(ArrayDeque<Runnable> tasks, Object mutex) {
        this.tasks = tasks;
        this.mutex = mutex;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (mutex) {
                while (tasks.isEmpty()) {
                    try {
                        mutex.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException("The error has occurred in thread " +
                                Thread.currentThread().getName() + " : ", e);
                    }
                }
                task = tasks.pop();
            }
            // NoSuchElementException cannot raise because isEmpty() check
            // under synchronization was made.
            task.run();
        }

    }
}
