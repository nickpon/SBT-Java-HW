package ru.sberbank.mipt.threads.executionManager;

import java.util.ArrayList;
import java.util.List;

public class MyContextImplementation implements Context {

    private final Runnable callback;
    private final Runnable[] tasks;
    private volatile int completedTasksCount;
    private volatile int failedTaskCount;
    private volatile int interruptedTaskCount;
    private volatile int numberOfTasks;
    private List<Thread> threads;

    public MyContextImplementation(Runnable callback, Runnable[] tasks) {
        this.callback = callback;
        this.tasks = tasks;
        threads = new ArrayList<>();
        numberOfTasks = tasks.length;
        startComputation();
    }

    @Override
    public int getCompletedTaskCount() {
        return completedTasksCount;
    }

    @Override
    public int getFailedTaskCount() {
        return failedTaskCount;
    }

    @Override
    public int getInterruptedTaskCount() {
        return interruptedTaskCount;
    }

    @Override
    public void interrupt() {
        for (int i = 0; i < threads.size(); i++) {
            threads.get(i).interrupt();
        }
    }

    @Override
    public synchronized boolean isFinished() {
        return (interruptedTaskCount + completedTasksCount + failedTaskCount == numberOfTasks);
    }

    private synchronized void startComputation() {
        for (int taskNumber = 0; taskNumber < tasks.length; taskNumber++) {
            Runnable task = tasks[taskNumber];
            Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                if (!Thread.currentThread().isInterrupted()) {
                    try {
                        synchronized (this) {
                            task.run();
                            ++completedTasksCount;
                        }
                    } catch (RuntimeException e) {
                        synchronized (this) {
                            System.err.println("RuntimeException occurred while running " + Thread.currentThread().getName());
                            ++failedTaskCount;
                        }
                    }
                } else {
                    synchronized (this) {
                        ++interruptedTaskCount;
                    }
                }

                // Will not start it's actual finnish due to == numberOfTasks check.
                if (isFinished()) {
                    callback.run();
                }
            }

            private synchronized boolean isFinished() {
                return (interruptedTaskCount + completedTasksCount + failedTaskCount == numberOfTasks);
            }
            });
            threads.add(thread);
            thread.start();
        }
    }
}