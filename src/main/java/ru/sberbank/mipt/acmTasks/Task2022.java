package ru.sberbank.mipt.acmTasks;

import java.util.Scanner;

public class Task2022 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (arr[i] % arr[j] == 0) {
                    ++res;
                }
            }
        }
        System.out.println(res);
    }
}