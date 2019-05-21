package ru.sberbank.mipt.acmTasks;

import java.util.Scanner;

public class Task2007 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = 1;
        int num = 0;
        while (n % Math.pow(2, i) == 0) {
            ++num;
            ++i;
        }
        System.out.println(num);
    }
}
