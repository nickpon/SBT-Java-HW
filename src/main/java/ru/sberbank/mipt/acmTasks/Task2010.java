package ru.sberbank.mipt.acmTasks;

import java.util.Scanner;

public class Task2010 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int num = 0;
        while (a > 0 && b > 0) {
            ++num;
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        System.out.print(num);
        System.out.print(" ");
        System.out.print(Math.max(a, b));
    }
}