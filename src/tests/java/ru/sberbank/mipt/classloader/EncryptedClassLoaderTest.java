package ru.sberbank.mipt.classloader;

import org.junit.Test;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

public class EncryptedClassLoaderTest {

    @Test
    public void Test() throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException {
        String key = ""; // because key.length() will be zero, so encoder will do nothing.

        File dir = new File("C:\\Users\\Ponom\\Desktop\\SBT-Java-HW\\out\\" +
                "test\\SBT-Java-HW\\");

        EncryptedClassLoader cl = new EncryptedClassLoader(key, dir,
                ClassLoader.getSystemClassLoader());

        Class<?> testClass = cl.findClass("ru.sberbank.mipt.classloader.encryptedClassLoaderTestDir." +
                "EncryptedClassLoaderTest");
        Object TestClassInstance = testClass.newInstance();
        Method[] methods = TestClassInstance.getClass().getMethods();

        StringBuilder ans = new StringBuilder();
        for (Method method : methods) {
            if (method.getName().equals("hello")) {
                ans.append(method.invoke(TestClassInstance));
            }
        }

        assertEquals("hello", ans.toString());
    }
}
