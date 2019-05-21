package ru.sberbank.mipt.reflection;

import org.junit.Test;

import static org.junit.Assert.*;

import static ru.sberbank.mipt.reflection.BeanUtils.assign;

public class BeanUtilsTests {

    @Test
    public void OneFieldChangeTest() {
        OneFieldClass to = new OneFieldClass();
        to.setVal1(3);
        OneFieldClass from = new OneFieldClass();
        from.setVal1(5);
        assign(to, from);
        assertEquals(5, to.getVal1());
        assertEquals(5, from.getVal1());
    }

    @Test
    public void MultipleFieldChangeTest() {
        MultipleFieldClass to = new MultipleFieldClass();
        to.setVal1(1);
        to.setVal2(2);
        to.setVal3(3);
        MultipleFieldClass from = new MultipleFieldClass();
        from.setVal1(4);
        from.setVal2(5);
        from.setVal3(6);
        assign(to, from);
        assert ((to.getVal1() == 4) && (to.getVal2() == 5) &&
                (to.getVal3() == 6));
        assert ((from.getVal1() == 4) && (from.getVal2() == 5) &&
                (from.getVal3() == 6));
    }

    @Test
    public void DifferentFieldsTest1() {
        MultipleFieldClass to = new MultipleFieldClass();
        to.setVal1(1);
        to.setVal2(2);
        to.setVal3(3);
        OneFieldClass from = new OneFieldClass();
        from.setVal1(4);
        assign(to, from);
        assert ((to.getVal1() == 4) && (to.getVal2() == 2) &&
                (to.getVal3() == 3));
        assertEquals(4, from.getVal1());
    }

    @Test
    public void DifferentFieldsTest2() {
        OneFieldClass to = new OneFieldClass();
        to.setVal1(1);
        MultipleFieldClass from = new MultipleFieldClass();
        from.setVal1(2);
        from.setVal2(3);
        from.setVal3(4);
        assign(to, from);
        assertEquals(2, to.getVal1());
        assert ((from.getVal1() == 2) && (from.getVal2() == 3) &&
                (from.getVal3() == 4));
    }
}
