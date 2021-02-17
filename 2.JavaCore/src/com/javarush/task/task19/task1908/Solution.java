package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.regex.Pattern;

/* 
Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки.
Пример тела файла:
12 text var2 14 8ю 1
Результат:
12 14 1
Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором принимающим FileReader).
4. Поток чтения из файла (BufferedReader) должен быть закрыт.
5. Программа должна записывать во второй файл все числа, через пробел, из первого файла (используй
BufferedWriter с конструктором FileWriter).
6. Поток записи в файл (BufferedWriter) должен быть закрыт.
C:/Games/file1.txt
C:/Games/int.txt
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader read = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(reader.readLine()));
        String s;
        Pattern p = Pattern.compile("\\s+", Pattern.UNICODE_CHARACTER_CLASS);

        while ((s =read.readLine()) != null){
            s = s.replaceAll("[\\n\\t\\f\\r,!\".@#$%|{}^\\[\\]&*()/\\\\=]", " ");
            s = s.trim();
            String[] array = p.split(s);
            for(String str: array){
                if(Pattern.matches("\\b\\d+\\b", str)){
                writer.write(str + " ");}
            }
        }
        reader.close();
        read.close();
        writer.close();
    }
}
