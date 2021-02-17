package com.javarush.task.task22.task2202;

/* 
Найти подстроку
1. Класс TooShortStringException должен быть потомком класса RuntimeException.
2. Метод getPartOfString должен принимать строку в качестве параметра.
3. В случае, если в метод getPartOfString были переданы некорректные данные, должно возникнуть
исключение TooShortStringException.
4. Метод getPartOfString должен возвращать подстроку начиная с символа после
 1-го пробела и до конца слова, которое следует после 4-го пробела.
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        try{
            String[] array = string.split(" ");
            //if(array.length < 5) throw new TooShortStringException();
            StringBuilder result = new StringBuilder();
            result.append(array[1] + " ").append(array[2] + " ").append(array[3] + " ").append(array[4]);
            return result.toString();
        } catch (RuntimeException e){
            throw new TooShortStringException();
        }

    }

    public static class TooShortStringException extends RuntimeException {
    }
}
