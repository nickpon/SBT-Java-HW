package ru.sberbank.mipt.threads.executionManager;

public interface ExecutionManager {
    Context execute(Runnable callback, Runnable... tasks);
}