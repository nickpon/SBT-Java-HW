package ru.sberbank.mipt.acmTasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class Task2056 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> dict = new HashMap<>();
        while (scanner.hasNext()) {
            String str = scanner.next();
            str = str.toLowerCase();
            /*if (str.equals("kek")) {
                break;
            }*/
            if (dict.get(str) == null) {
                dict.put(str, 1);
            } else {
                dict.replace(str, dict.get(str), dict.get(str) + 1);
            }
        }
        int maxEl = 0;
        for (String i : dict.keySet()) {
            if (maxEl < dict.get(i)) {
                maxEl = dict.get(i);
            }
        }
        List<String> lst = new ArrayList<>();
        for (String i : dict.keySet()) {
            if (maxEl == dict.get(i)) {
                lst.add(i);
            }
        }
        Collections.sort(lst);
        for (String i : lst) {
            System.out.println(i);
        }
    }
}