package ru.sberbank.mipt.reflection;

public class MultipleFieldClass {
    public int getVal1() {
        return val1;
    }

    public int getVal2() {
        return val2;
    }

    public int getVal3() {
        return val3;
    }

    public void setVal1(int val1) {
        this.val1 = val1;
    }

    public void setVal2(int val2) {
        this.val2 = val2;
    }

    public void setVal3(int val3) {
        this.val3 = val3;
    }

    private int val1 = 0;
    private int val2 = 0;
    private int val3 = 0;
}
