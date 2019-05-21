package ru.sberbank.mipt.acmTasks;

import java.util.Scanner;

public class Task2011 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n < 7) {
            System.out.println("preschool child");
        } else if (n <= 17) {
            System.out.println("schoolchild " + (n - 6));
        } else if (n <= 22) {
            System.out.println("student " + (n - 17));
        } else {
            System.out.println("specialist");
        }
    }
}