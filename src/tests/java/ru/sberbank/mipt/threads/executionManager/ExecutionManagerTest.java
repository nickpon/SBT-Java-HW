package ru.sberbank.mipt.threads.executionManager;

public class ExecutionManagerTest {
    public static void main(String[] args) {
        MyShortRunnable task0 = new MyShortRunnable("Null");
        MyShortRunnable task1 = new MyShortRunnable("First");
        MyLongRunnable task2 = new MyLongRunnable("Second"); // Long one.
        MyShortRunnable task4 = new MyShortRunnable("Third");
        Runnable callback = new Runnable() {
            @Override
            public void run() {
                System.out.println("Callback");
            }
        };
        complete(callback, task0, task1, task2, task4);
    }

    private static synchronized void complete(Runnable callback, Runnable... tasks) {
        ExecutionManager executionManager = new MyExecutionManagerImplementation();
        MyContextImplementation context = (MyContextImplementation) executionManager.execute(callback, tasks);

        try {
            Thread.sleep(4000);
            context.interrupt();
            Thread.sleep(4000);
            System.out.println(context.isFinished());
            System.out.println(context.getCompletedTaskCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
