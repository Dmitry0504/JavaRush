package com.javarush.task.task22.task2202;

/* 
����� ���������
1. ����� TooShortStringException ������ ���� �������� ������ RuntimeException.
2. ����� getPartOfString ������ ��������� ������ � �������� ���������.
3. � ������, ���� � ����� getPartOfString ���� �������� ������������ ������, ������ ����������
���������� TooShortStringException.
4. ����� getPartOfString ������ ���������� ��������� ������� � ������� �����
 1-�� ������� � �� ����� �����, ������� ������� ����� 4-�� �������.
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - ������ ������ �������� Java."));
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
