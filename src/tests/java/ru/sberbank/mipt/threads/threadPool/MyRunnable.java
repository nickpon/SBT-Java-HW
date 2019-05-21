package ru.sberbank.mipt.threads.threadPool;

public class MyRunnable implements Runnable {
    private final int number;

    MyRunnable(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("First call " + number);
        System.out.println("Second call " + number);
    }
}
