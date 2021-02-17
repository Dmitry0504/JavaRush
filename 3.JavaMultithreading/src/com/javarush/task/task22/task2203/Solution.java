package com.javarush.task.task22.task2203;

/* 
����� �����������
1. ����� TooShortStringException ������ ���� �������� ������ Exception.
2. ����� getPartOfString ������ ��������� ������ � �������� ���������.
3. � ������, ���� ������, ���������� � ����� getPartOfString �������� �����
 2 ��������� ������ ���������� ���������� TooShortStringException.
4. ����� getPartOfString ������ ���������� ��������� ����� ������ � ������ ����������.
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
