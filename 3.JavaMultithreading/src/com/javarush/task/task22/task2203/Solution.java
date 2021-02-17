package com.javarush.task.task22.task2203;

/* 
ћежду табул€ци€ми
1.  ласс TooShortStringException должен быть потомком класса Exception.
2. ћетод getPartOfString должен принимать строку в качестве параметра.
3. ¬ случае, если строка, переданна€ в метод getPartOfString содержит менее
 2 табул€ций должно возникнуть исключение TooShortStringException.
4. ћетод getPartOfString должен возвращать подстроку между первой и второй табул€цией.
*/

public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        try {
            char[] arr = string.toCharArray();
            int count = 0;
            for(char ch: arr){
                if(ch == 9) count++;}
            if(count < 2) throw new TooShortStringException();
            String[] array = string.split("\t");
            return array[1];
        }catch (Exception e){
            throw new TooShortStringException();
        }


    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("yg\tkg\tjk"));
    }
}
