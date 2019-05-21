package ru.sberbank.mipt.classloader.secondTestDir;

        import ru.sberbank.mipt.classloader.Plugin;

public class TestClass implements Plugin {
    @Override
    public void doUsefull() {
        System.out.println("Second!");
    }
}
