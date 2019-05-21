package ru.sberbank.mipt.acmTasks;

import java.util.Scanner;

public class Task2013 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int min = 10001;
        int num = 0;
        int a = 0;
        for (int i = 0; i < n; i++) {
            a = scanner.nextInt();
            if (a == min) {
                ++num;
            }
            if (a < min) {
                min = a;
                num = 1;
            }
        }
        System.out.println(num);
    }
}
