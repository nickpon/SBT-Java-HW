package ru.sberbank.mipt.acmTasks;

import java.util.Scanner;

public class Task2008 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int w = scanner.nextInt();
        int sum = 0;
        int num = 0;
        int a = 0;
        for (int i = 0; i < n; i++) {
            a = scanner.nextInt();
            if ((a + sum) <= w) {
                sum += a;
                ++num;
            }
        }
        System.out.print(num);
        System.out.print(" ");
        System.out.println(sum);
    }
}
