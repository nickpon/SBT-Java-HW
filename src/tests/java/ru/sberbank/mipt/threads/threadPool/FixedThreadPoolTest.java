package ru.sberbank.mipt.threads.threadPool;

public class FixedThreadPoolTest {
    public static void main(String[] args) {
        FixedThreadPool tp = new FixedThreadPool(3);
        MyRunnable one = new MyRunnable(0);
        MyRunnable two = new MyRunnable(1);
        tp.execute(one);
        tp.execute(two);
        tp.start();
        tp.execute(two);
        tp.execute(one);
    }
}
