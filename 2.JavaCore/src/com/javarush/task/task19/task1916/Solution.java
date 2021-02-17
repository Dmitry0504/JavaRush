package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
Считать с консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines.
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME.
Пустые строки даны в примере для наглядности.
В оригинальном и редактируемом файлах пустых строк нет!

Пример 1:
оригинальный    редактированный    общий
file1:          file2:             результат:(lines)

строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
строка4                            REMOVED строка4
строка5         строка5            SAME строка5
                строка0            ADDED строка0
строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
                строка4            ADDED строка4
строка5         строка5            SAME строка5
строка0                            REMOVED строка0

Пример 2:
оригинальный    редактированный    общий
file1:          file2:             результат:(lines)

строка1         строка1            SAME строка1
                строка0            ADDED строка0

Пустые строки в примере означают, что этой строки нет в определенном файле.

*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();
    static List<String> list1 = new ArrayList<>();
    static List<String> list2 = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file1));
        while (bufferedReader.ready()){
            list1.add(bufferedReader.readLine());
        }
        bufferedReader.close();
        bufferedReader = new BufferedReader(new FileReader(file2));
        while (bufferedReader.ready()){
            list2.add(bufferedReader.readLine());
        }
        bufferedReader.close();
        reader.close();
        while (list1.size() > 0 && list2.size() > 0) {
            if (list1.get(0).equals(list2.get(0))) {
                lines.add(new LineItem(Type.SAME, list1.get(0)));
                list1.remove(list1.get(0));
                list2.remove(list2.get(0));
            }
            else if (list1.get(1).equals(list2.get(0))) {
                lines.add(new LineItem(Type.REMOVED, list1.get(0)));
                list1.remove(list1.get(0));
            }
            else {
                lines.add(new LineItem(Type.ADDED, list2.get(0)));
                list2.remove(list2.get(0));
            }
        }
        if(list1.size() > 0){
            for(String s: list1){
                lines.add(new LineItem(Type.REMOVED, s));
            }
        }
        if(list2.size() > 0){
            for(String s: list2){
                lines.add(new LineItem(Type.ADDED, s));
            }
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
