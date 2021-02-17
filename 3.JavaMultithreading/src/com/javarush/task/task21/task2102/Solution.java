package com.javarush.task.task21.task2102;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* 
Сравниваем модификаторы
Реализовать логику метода isModifierSet, который проверяет, содержит ли переданный параметр
allModifiers значение конкретного модификатора specificModifier.
P.S. Перед выполнением задания ознакомься с классом Modifier и реализацией методов isPublic, isStatic и т.п.
Требования:
1. Метод isModifierSet должен быть статическим.
2. Метод isModifierSet должен возвращать значение типа boolean.
3. Метод isModifierSet должен принимать два параметра типа int.
4. Метод isModifierSet должен возвращать корректное значение в соответствии с условием
задачи(true, если заданный модификатор присутствует в allModifiers, иначе false).
*/
public class Solution {
    public static void main(String[] args) {
        int classModifiers = Solution.class.getModifiers();
        System.out.println(isModifierSet(classModifiers, Modifier.PUBLIC));   //true
        System.out.println(isModifierSet(classModifiers, Modifier.STATIC));   //false

        int methodModifiers = getMainMethod().getModifiers();
        System.out.println(isModifierSet(methodModifiers, Modifier.STATIC));      //true
    }

    public static boolean isModifierSet(int allModifiers, int specificModifier) {
        if(specificModifier == Modifier.PUBLIC)          return Modifier.isPublic(allModifiers);

        if(specificModifier == Modifier.PRIVATE)            return Modifier.isPrivate(allModifiers);

        if(specificModifier == Modifier.PROTECTED)         return Modifier.isProtected(allModifiers);

        if(specificModifier == Modifier.STATIC)            return Modifier.isStatic(allModifiers);

        if(specificModifier == Modifier.ABSTRACT)            return Modifier.isAbstract(allModifiers);

        if(specificModifier == Modifier.FINAL)            return Modifier.isFinal(allModifiers);

        if(specificModifier == Modifier.INTERFACE)            return Modifier.isInterface(allModifiers);

        if(specificModifier == Modifier.NATIVE)            return Modifier.isNative(allModifiers);

        if(specificModifier == Modifier.STRICT)            return Modifier.isStrict(allModifiers);

        if(specificModifier == Modifier.SYNCHRONIZED)            return Modifier.isSynchronized(allModifiers);

        if(specificModifier == Modifier.TRANSIENT)            return Modifier.isTransient(allModifiers);

        if(specificModifier == Modifier.VOLATILE)            return Modifier.isVolatile(allModifiers);

        return false;
    }

    private static Method getMainMethod() {
        Method[] methods = Solution.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("main")) return method;
        }

        return null;
    }
}
