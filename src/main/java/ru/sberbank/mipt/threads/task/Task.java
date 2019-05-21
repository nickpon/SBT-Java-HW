package ru.sberbank.mipt.threads.task;

import java.util.concurrent.Callable;

public class Task<T> {

    private final Callable<? extends T> callable;
    private volatile boolean isComputationStarted;
    private volatile boolean isComputed;
    private volatile T result;
    private final Object mutex;
    private volatile RuntimeException exception;

    public Task(Callable<? extends T> callable) {
        this.callable = callable;
        isComputationStarted = false;
        isComputed = false;
        mutex = new Object();
        exception = null;
    }

    public T get() {
        if (isComputed) {
            if (exception == null) {
                return result;
            }
            throw exception;
        }
        if (isComputationStarted) {
            synchronized (this) {
                while (!isComputed) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        exception = new RuntimeException("The error has occurred : ", e);
                    }
                }
            }
            if (exception == null) {
                return result;
            }
            throw exception;
        }
        return compute();
    }

    private T compute() {
        synchronized (mutex) {
            isComputationStarted = true;
        }
        synchronized (this) {
            try {
                result = callable.call();
            } catch (Exception e) {
                exception = new RuntimeException("While computing error has occurred : " + e);
            }
        }
        synchronized (mutex) {
            isComputed = true;
        }
        synchronized (this) {
            notifyAll();
        }
        if (exception == null) {
            return result;
        }
        throw exception;
    }
}