package ru.sberbank.mipt.acmTasks;

import java.util.Scanner;

public class Task2004 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        System.out.println((((year % 4 == 0) && (year % 100 != 0)) ||
                (year % 400 == 0)) ? 1 : 0);
    }
}
