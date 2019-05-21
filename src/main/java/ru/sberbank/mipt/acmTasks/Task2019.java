package ru.sberbank.mipt.acmTasks;

import java.util.Scanner;

public class Task2019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = 1;
        do {
            n -= i;
            ++i;
        } while (n > 0);
        System.out.println(--i);
    }
}