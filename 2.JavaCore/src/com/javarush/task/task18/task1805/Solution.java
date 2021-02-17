package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все уникальные байты из файла в порядке возрастания.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(reader.readLine());
        Set<Byte> set = new HashSet<>();
        while (file.available() > 0){
            set.add((byte) file.read());
        }
        ArrayList<Byte> list = new ArrayList<>();
        list.addAll(set);
        Collections.sort(list);
        //System.out.println(list);
        for(Byte b: list){
            System.out.print(b + " ");
        }
        reader.close();
        file.close();
        //C:\Games\int.txt
    }
}
