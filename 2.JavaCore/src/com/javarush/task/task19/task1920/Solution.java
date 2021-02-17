package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Вывести в консоль имена в алфавитном порядке, у которых максимальная сумма.
Имена разделять пробелом либо выводить с новой строки.
Закрыть потоки.
Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85
Пример вывода:
Петров
Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое файла (используй FileReader).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна выводить в консоль имена, у которых максимальная сумма.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<String, Double> map = new TreeMap<>();
        String file = args[0];
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while (reader.ready()){
            String[] array = reader.readLine().split(" ");
            double i = map.get(array[0]) == null? 0 : map.get(array[0]);
            map.put(array[0], Double.parseDouble(array[1]) + i);
        }
        reader.close();
        //System.out.println(map);
        Map.Entry<String, Double> maxEntry = null;
        for(Map.Entry<String, Double> entry: map.entrySet()){
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
            {
                maxEntry = entry;
            }
        }
        TreeMap<String, Double> copyMap = new TreeMap<>(map);
        for(Map.Entry<String, Double> entry1: map.entrySet()){
            if (entry1.getValue().compareTo(maxEntry.getValue()) < 0)
            {
               copyMap.remove(entry1.getKey());
            }
        }
        TreeSet<String> set = new TreeSet<>(copyMap.keySet());

        for (String s : set) {
            System.out.println(s);
        }
    }
}
