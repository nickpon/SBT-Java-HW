package ru.sberbank.mipt.acmTasks;

import java.util.Scanner;

public class Task2020 {
    /*
    I have never seen anything as bad as this code!
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int num = a;
        int kol = 1;
        int maxNum = num;
        int maxKol = kol;
        for (int i = 1; i < n; i++) {
            //System.out.println(num + " " + kol + " " + maxKol + " " + maxNum);
            a = scanner.nextInt();
            if (a != num) {
                if (maxKol < kol) {
                    maxKol = kol;
                    maxNum = num;
                }
                num = a;
                kol = 1;
            } else {
                ++kol;
            }
        }
        if (maxKol < kol) {
            maxKol = kol;
            maxNum = num;
        }
        System.out.println(maxNum + " " + maxKol);
    }
}