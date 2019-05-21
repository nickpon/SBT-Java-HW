package ru.sberbank.mipt.acmTasks;

import java.util.Scanner;

public class Task2018 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a;
        int sum = 0;
        int group = 2;
        sum += scanner.nextInt();
        int num = 1;
        for (int i = 1; i < n; i++) {
            a = scanner.nextInt();
            if (group % 2 != 0) {
                sum += a;
            } else {
                sum -= a;
            }
            if (num % group == 0) {
                ++group;
                num = 1;
            } else {
                ++num;
            }
        }
        System.out.println(sum);
    }
}