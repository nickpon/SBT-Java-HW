package ru.sberbank.mipt.classloader;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class PluginManagerTest {

    @Test
    public void Test() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        // Default class loader.

        URL url2 = (new File("C:\\Users\\Ponom\\Desktop\\SBT-Java-HW\\out\\" +
                "test\\SBT-Java-HW\\ru\\sberbank\\mipt\\classloader\\ClassLoaderTest.jar").toURI().toURL());

        URLClassLoader classLoader = new URLClassLoader(new URL[]{url2});
        Class<?> clz = classLoader.loadClass("ru.sberbank.mipt.classloader.firstTestDir.TestClass");
        Object TestClassInstance = clz.newInstance();

        Method[] methodsObjectClass = TestClassInstance.getClass().getMethods();
        Method doUsefull1 = null;
        for (Method method : methodsObjectClass) {
            if (method.getName().equals("doUsefull")) {
                doUsefull1 = method;
            }
        }
        doUsefull1.invoke(TestClassInstance);

        // Custom classloader.
        PluginManager pluginManagerTest = new PluginManager("C:\\Users\\Ponom\\Desktop\\SBT-Java-HW\\out\\" +
                "test\\SBT-Java-HW\\ru\\sberbank\\mipt\\classloader");
        Plugin pluginTest = pluginManagerTest.load("ClassLoaderTest.jar", "ru.sberbank.mipt.classloader.secondTestDir.TestClass");

        Method[] methodsTest = pluginTest.getClass().getMethods();
        Method doUsefull2 = null;
        for (Method method : methodsTest) {
            if (method.getName().equals("doUsefull")) {
                doUsefull2 = method;
            }
        }
        doUsefull2.invoke(pluginTest);
    }
}