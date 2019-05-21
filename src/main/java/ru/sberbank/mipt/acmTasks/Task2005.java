package ru.sberbank.mipt.acmTasks;

import java.util.Scanner;

public class Task2005 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int index = 1;
        int minVal = 10000;
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            if (num < minVal) {
                minVal = num;
                index = i + 1;
            }
        }
        System.out.println(index);
    }
}
