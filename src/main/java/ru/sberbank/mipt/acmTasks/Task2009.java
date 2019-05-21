package ru.sberbank.mipt.acmTasks;

import java.util.Scanner;

public class Task2009 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        int power = 0;
        int a = 0;
        for (int i = 0; i < n; i++) {
            a = scanner.nextInt();
            if ((i + 1) == Math.pow(2, power)) {
                ++power;
                sum += a;
            }
        }
        System.out.println(sum);
    }
}