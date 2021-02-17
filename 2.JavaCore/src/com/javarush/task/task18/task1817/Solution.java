package com.javarush.task.task18.task1817;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45.
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой.
4. Закрыть потоки.
Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток чтения из файла, который приходит первым параметром в main.
3. Посчитай отношение пробелов ко всем символам в файле и выведи в консоль это число.
4. Выведенное значение необходимо округлить до 2 знаков после запятой.
5. Поток чтения из файла должен быть закрыт.
*/

public class Solution {

    public static void main(String[] args) throws IOException {

        int countSpaces = 0;
        FileReader reader = new FileReader(args[0]);
        BufferedReader read = new BufferedReader(reader);
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = read.readLine()) !=null){
            sb.append(s);
        }
        Pattern pattern = Pattern.compile(" ");
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()){
            countSpaces++;
        }
//        System.out.println(sb);
//        System.out.println(countSpaces);
        System.out.printf("%.2f" ,(double) countSpaces/sb.length()*100);
        read.close();
        reader.close();
    }
}
