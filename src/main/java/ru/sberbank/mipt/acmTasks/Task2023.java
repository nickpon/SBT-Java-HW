package ru.sberbank.mipt.acmTasks;

import java.util.*;

public class Task2023 {
    /*
    I have never seen anything as bad as this code!
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        Set<Integer> hashSet = new HashSet<>();
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            hashSet.add(scanner.nextInt());
        }
        ArrayList<Integer> c = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (hashSet.contains(a[i])) {
                c.add(a[i]);
            }
        }
        System.out.println(c.size());
        for (int i = 0; i < c.size(); i++) {
            if (i != c.size() - 1) {
                System.out.print(c.get(i) + " ");
            } else {
                System.out.print(c.get(i));
            }
        }
        if (c.isEmpty()) {
            System.out.println();
        }
    }
}
