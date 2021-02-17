package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков '-', которые не могут идти подряд
4) может содержать 1 пару скобок '(' и ')' , причем если она есть, то она расположена левее знаков '-'
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру

1. Метод checkTelNumber должен возвращать значение типа boolean.
2. Метод checkTelNumber должен быть публичным.
3. Метод checkTelNumber должен принимать один параметр типа String.
4. Метод checkTelNumber должен корректно проверять валидность номера телефона переданного ему в качестве параметра.
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    static int n;
    static boolean b;
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null) return false;
        else {
            Pattern p12 = Pattern.compile(
                    "^(\\+|\\d)?\\d?\\d?\\(?\\d\\d\\d(\\)?|\\-?)\\d\\-?\\d\\-?\\d\\-?\\d\\-?\\d?\\-?\\d?\\-?\\d?\\-?$");
            Pattern pdefis = Pattern.compile("^(\\d|\\().+");
            Matcher m = p12.matcher(telNumber);
            b = pdefis.matcher(telNumber).matches();
            n = telNumber.replaceAll("\\D", "").length();

            char[] array = telNumber.toCharArray();
            int count = 0;
            int countskobok = 0;
            for (char c : array) {
                if (c == '-') count++;
            }
            for (char c : array) {
                if (c == '(' || c == ')') countskobok++;
            }
            if (count > 2) return false;
            else if (countskobok == 1) return false;
            else if (telNumber.startsWith("+") && n != 12) return false;
            else if (pdefis.matcher(telNumber).matches() && n != 10) return false;
            else return m.matches();
        }
    }

    public static void main(String[] args) {
        //тестируем
        System.out.println(checkTelNumber(null));
        System.out.println(checkTelNumber("+38(050)1234567"));
        //System.out.println("n" + n + b);
        System.out.println(checkTelNumber("+38050123-45-67"));
        System.out.println(checkTelNumber("050123-4567"));
        System.out.println("n" + n + b);
        System.out.println(checkTelNumber("+38)050(1234567"));
        System.out.println(checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println(checkTelNumber("050ххх4567"));
        System.out.println(checkTelNumber("0501203456"));
        System.out.println(checkTelNumber("(018)9234567"));
    }
}
