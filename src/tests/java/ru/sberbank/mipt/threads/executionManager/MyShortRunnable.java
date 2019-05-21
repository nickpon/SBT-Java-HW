package ru.sberbank.mipt.threads.executionManager;

public class MyShortRunnable implements Runnable {
    private final String str;

    public MyShortRunnable(String str) {
        this.str = str;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Exception has occurred : " + e);
        }
        System.out.println(str);
    }
}
