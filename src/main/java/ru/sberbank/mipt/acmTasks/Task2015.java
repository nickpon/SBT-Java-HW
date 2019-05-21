package ru.sberbank.mipt.acmTasks;

import java.util.Scanner;

public class Task2015 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n >= 2) {
            System.out.println("2");
        }
        for (int i = 2; i <= n; i++) {
            boolean flag = false;
            for (int j = 2; j < Math.ceil(Math.sqrt((double)i)) + 1; j++) {
                if (i % j == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println(i);
            }
        }
    }
}