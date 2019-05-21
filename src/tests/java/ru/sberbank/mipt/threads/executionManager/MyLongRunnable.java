package ru.sberbank.mipt.threads.executionManager;

public class MyLongRunnable implements Runnable {
    private final String str;

    public MyLongRunnable(String str) {
        this.str = str;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Exception has occurred : " + e);
        }
        System.out.println(str);
    }
}