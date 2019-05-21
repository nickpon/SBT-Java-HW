package ru.sberbank.mipt.classloader.firstTestDir;

import ru.sberbank.mipt.classloader.Plugin;

public class TestClass implements Plugin {
    @Override
    public void doUsefull() {
        System.out.println("First!");
    }
}
