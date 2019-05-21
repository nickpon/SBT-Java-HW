package ru.sberbank.mipt.acmTasks;

import java.util.Scanner;

public class Task2021 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int maxVal = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] == maxVal) {
                arr[i] /= 2;
            }
        }
        maxVal = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] == maxVal) {
                arr[i] /= 2;
            }
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
