package ru.sberbank.mipt.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class BeanUtils {

    /**
     * Scans object "from" for all getters. If object "to"
     * <p>
     * contains correspondent setter, it will invoke it
     * <p>
     * to set property value for "to" which equals to the property
     * <p>
     * of "from".
     * <p>
     * <p/>
     * <p>
     * The type in setter should be compatible to the value returned
     * <p>
     * by getter (if not, no invocation performed).
     * <p>
     * Compatible means that parameter type in setter should
     * <p>
     * be the same or be superclass of the return type of the getter.
     * <p>
     * <p/>
     * <p>
     * The method takes care only about public methods.
     *
     * @param to   Object which properties will be set.
     * @param from Object which properties will be used to get values.
     */
    public static void assign(Object to, Object from) {
        // List of all getters of the from object.
        ArrayList<Method> fromGetters = properMethods("getter", from);
        // List of all setters of the to object.
        ArrayList<Method> toSetters = properMethods("setter", to);

        for (Method getter : fromGetters) {
            // Name of the field to which getter method corresponds.
            // Skips first 3 characters that stands for "get".
            String nameGetter = getter.getName().substring(3);
            // Type of the getter return instance.
            Class classTypeGetter = getter.getReturnType();

            for (Method setter : toSetters) {
                // Name of the field to which setter method corresponds.
                // Skips first 3 characters that stands for "set".
                String nameSetter = setter.getName().substring(3);
                // Types of the setter initial parameters.
                Class[] paramsSetter = setter.getParameterTypes();

                // Check if setter and getter correspond to the same field and
                // type of setter initial parameter and type of getter output are the same.
                if ((nameGetter.equals(nameSetter)) &&
                        (paramsSetter[0].getName().equals(classTypeGetter.toString()))) {

                    // Invoke setter from to object with the result of getter from from object.
                    try {
                        setter.invoke(to, getter.invoke(from));
                    } catch (IllegalArgumentException e) {
                        throw new RuntimeException("caught IllegalArgumentException in getter");
                    } catch (InvocationTargetException e) {
                        throw new RuntimeException("caught InvocationTargetException in getter");
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("caught IllegalAccessException in getter");
                    }
                }
            }
        }
    }

    /**
     * @param type   {"getter", "setter"} Which methods ought to be obtained.
     * @param object Object which properties from which getters or setters will be attained.
     * @return ArrayList<Method> List of all getter or setter methods of the object given.
     */
    private static ArrayList<Method> properMethods(String type, Object object) {
        Class objectClass = object.getClass();
        Method[] methodsObjectClass = objectClass.getMethods();
        // List to store setters or getters.
        ArrayList<Method> properMethods = new ArrayList<>();

        if (type.equals("getter")) {
            for (Method method : methodsObjectClass) {
                if (isGetter(method)) {
                    properMethods.add(method);
                }
            }
        } else {
            for (Method method : methodsObjectClass) {
                if (isSetter(method)) {
                    properMethods.add(method);
                }
            }
        }
        return properMethods;
    }

    /**
     * Method to check if it is getter or not.
     *
     * @param method Method to check.
     * @return True if the method is getter and false if it is not.
     */
    private static boolean isGetter(Method method) {
        if (!method.getName().startsWith("get")) return false;
        if (method.getParameterTypes().length != 0) return false;
        if (void.class.equals(method.getReturnType())) return false;
        return true;
    }

    /**
     * Method to check if it is setter or not.
     *
     * @param method Method to check.
     * @return True if the method is setter and false if it is not.
     */
    private static boolean isSetter(Method method) {
        if (!method.getName().startsWith("set")) return false;
        if (method.getParameterTypes().length != 1) return false;
        return true;
    }
}