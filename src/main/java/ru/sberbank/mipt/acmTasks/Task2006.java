package ru.sberbank.mipt.acmTasks;

import java.util.Scanner;

public class Task2006 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int f = n / 36;
        n -= f * 36;
        double d = Math.round((double)n / 3.0);
        System.out.println(f);
        System.out.println((int)d);
    }
}
