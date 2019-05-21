package ru.sberbank.mipt.threads.task;

import java.util.concurrent.Callable;

public class MyCallableObjectWithException implements Callable {
    @Override
    public Object call() throws Exception {
        Thread.currentThread().sleep(5000);
        throw new RuntimeException("Jast for test.");
    }
}