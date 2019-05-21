package ru.sberbank.mipt.acmTasks;

import java.util.Scanner;

public class Task2036 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            String str = scanner.next();
            if (!isStrange(str)) {
                System.out.println(str);
            }
        }
    }

    private static boolean isStrange(String str) {
        for (int i = 0; i < str.length() - 2; i++) {
            if (isVowel(str, i) && isVowel(str, i + 1) && isVowel(str, i + 2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isVowel(String str, int i) {
        return ((str.charAt(i) == 'u') || (str.charAt(i) == 'y') || (str.charAt(i) == 'i') ||
                (str.charAt(i) == 'e') || (str.charAt(i) == 'o') || (str.charAt(i) == 'a'));
    }
}
