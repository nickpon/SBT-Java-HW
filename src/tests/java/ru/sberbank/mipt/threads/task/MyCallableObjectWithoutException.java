package ru.sberbank.mipt.threads.task;

import java.util.concurrent.Callable;

public class MyCallableObjectWithoutException implements Callable {
    @Override
    public Object call() throws Exception {
        Thread.sleep(5000);
        return "The task is completed.";
    }
}
