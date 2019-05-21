package ru.sberbank.mipt.acmTasks;

import java.util.Scanner;

public class Task2016 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        if (a != 0) {
            int D = b * b - 4 * a * c;
            if (D == 0) {
                System.out.println("1");
            } else if (D < 0) {
                System.out.println("0");
            } else {
                System.out.println("2");
            }
        } else if (b != 0) {
            System.out.println("1");
        } else if (c == 0) {
            System.out.println("-1");
        } else {
            System.out.println("0");
        }
    }
}
