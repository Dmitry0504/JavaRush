package com.javarush.task.task19.task1907;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки.
Требования:
1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader c конструктором принимающим String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль количество слов "world", которые встречаются в файле.
C:/Games/file1.txt
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader read = new BufferedReader(new FileReader(reader.readLine()));
        Pattern p = Pattern.compile("\\bworld\\b");
        int i = 0;
        String s;
        while ((s =read.readLine()) != null){
            Matcher m = p.matcher(s);
            while (m.find()) {i++;}
        }
        System.out.println(i);
        reader.close();
        read.close();
    }
}
