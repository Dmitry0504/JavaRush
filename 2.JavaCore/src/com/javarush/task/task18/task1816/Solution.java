package com.javarush.task.task18.task1816;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв).
Закрыть потоки.
Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток чтения из файла, который приходит первым параметром в main.
3. В файле необходимо посчитать буквы английского алфавита и вывести это число в консоль.
4. Нужно учитывать заглавные и строчные буквы.
5. Поток чтения из файла должен быть закрыт.
C:\\Games\\file1.txt
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Pattern p = Pattern.compile("[a-z]", Pattern.CASE_INSENSITIVE);
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String s;
        Matcher m;
        int count = 0;
        ArrayList<String> list = new ArrayList<>();
        while (reader.ready()){
            s = reader.readLine();
            list.add(s);
        }
        for(String str: list){
            m = p.matcher(str);
            while (m.find()) {count++;}
        }
        reader.close();
        System.out.println(count);

    }
}
