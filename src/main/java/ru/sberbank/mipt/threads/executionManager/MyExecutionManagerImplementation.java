package ru.sberbank.mipt.threads.executionManager;

public class MyExecutionManagerImplementation implements ExecutionManager {
    @Override
    public Context execute(Runnable callback, Runnable... tasks) {
        return new MyContextImplementation(callback, tasks);
    }
}