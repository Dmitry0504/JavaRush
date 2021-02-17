package com.javarush.task.task19.task1923;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со словами, разделенными пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d.
Закрыть потоки.

Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна записывать во второй файл все слова из первого файла которые содержат цифры
 (используй FileWriter).
5. Поток записи в файл (FileWriter) должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[1]));
        Pattern p = Pattern.compile(".*\\w*\\d+\\w*\\d*.*");
        Matcher m;
        while (bufferedReader.ready()){
            String s = bufferedReader.readLine();
            String[] array = s.split(" ");
            for(String str: array){
                m = p.matcher(str);
                if(m.matches()) bufferedWriter.write(str + " ");
            }
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
