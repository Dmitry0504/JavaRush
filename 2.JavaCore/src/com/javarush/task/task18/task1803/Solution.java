package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые частые байты
Самые частые байты
Ввести с консоли имя файла.
Найти байт или байты с максимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.
Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все байты из файла с максимальным количеством повторов.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        ArrayList<Byte> list = new ArrayList<>();
        HashMap<Byte, Integer> res = new HashMap<>();
        while (fis.available() > 0){
            list.add((byte) fis.read());
        }
 //       byte[] array = fis.readAllBytes();
//        for(int i = 0; i < array.length; i++){
//            list.add(array[i]);
//        }
//        Collections.sort(list);

        for (int i = 0; i < list.size(); i ++){
            int x = Collections.frequency(list, list.get(i));
            res.put(list.get(i), x);
        }

        for(Map.Entry<Byte, Integer> entry: res.entrySet()) {
            // get key
            Byte key = entry.getKey();
            // get value
            Integer value = entry.getValue();
            if(value.equals(Collections.max(res.values()))) System.out.print(key + " ");
        }
        reader.close();
        fis.close();
        //C:\Games\int.txt
    }
}
