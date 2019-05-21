package ru.sberbank.mipt.threads.task;

public class TaskTest {
    public static void main(String[] args)  {
        FirstTest();
//        SecondTask();
    }

    private static void FirstTest() {
        MyCallableObjectWithoutException myCallableObject = new MyCallableObjectWithoutException();
        Task task = new Task(myCallableObject);
        MyThread thread1 = new MyThread(task);
        MyThread thread2 = new MyThread(task);
        thread1.start();
        thread2.start();
    }

    private static void SecondTask() {
        MyCallableObjectWithException myCallableObject = new MyCallableObjectWithException();
        Task task = new Task(myCallableObject);
        MyThread thread1 = new MyThread(task);
        MyThread thread2 = new MyThread(task);
        thread1.start();
        thread2.start();
    }

    private static class MyThread extends Thread {
        private Task task;

        MyThread(Task task) {
            this.task = task;
        }

        @Override
        public void run() {
            try {
                System.out.println(task.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
