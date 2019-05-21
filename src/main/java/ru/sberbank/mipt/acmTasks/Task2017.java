package ru.sberbank.mipt.acmTasks;

import java.util.Scanner;

public class Task2017 {
    /*
    I have never seen anything as bad as this code!
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int num = 0;
        int maxNum = 0;
        for (int i = a; i < b + 1; i++) {
            for (int j = 2; j < i + 1; j++) {
                if (i % j == 0) {
                    ++num;
                }
            }
            if (num > maxNum) {
                maxNum = num;
            }
            num = 0;
        }
        int kol = 0;
        int last = 0;
        for (int i = a; i < b + 1; i++) {
            for (int j = 2; j < i + 1; j++) {
                if (i % j == 0) {
                    ++num;
                }
            }
            if (num == maxNum) {
                ++kol;
                last = i;
            }
            num = 0;
        }
        System.out.println(kol);
        for (int i = a; i < b + 1; i++) {
            for (int j = 2; j < i + 1; j++) {
                if (i % j == 0) {
                    ++num;
                }
            }
            if (num == maxNum) {
                System.out.print(i);
                if (i != last) {
                    System.out.print(",");
                }
            }
            num = 0;
        }
    }
}