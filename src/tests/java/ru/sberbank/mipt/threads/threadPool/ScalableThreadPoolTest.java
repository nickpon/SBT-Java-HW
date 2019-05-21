package ru.sberbank.mipt.threads.threadPool;

public class ScalableThreadPoolTest {
    public static void main(String[] args) {
        ScalableThreadPool tp = new ScalableThreadPool(1, 3);
        tp.start();
        MyRunnable one = new MyRunnable(0);
        MyRunnable two = new MyRunnable(1);
        tp.execute(one);
        tp.execute(two);
        tp.execute(two);
        tp.execute(one);
    }
}
