package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
Собираем файл из кусочков.
Считывать с консоли имена файлов.
Каждый файл имеет имя: [someName].partN.

Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.

Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end".
В папке, где находятся все прочтенные файлы, создать файл без суффикса [.partN].

Например, Lion.avi.

В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки.
Требования:
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "end".
2. Создай поток для записи в файл без суффикса [.partN] в папке, где находятся все считанные файлы.
3. В новый файл перепиши все байты из файлов-частей *.partN.
4. Чтение и запись должны происходить с использованием буфера.
5. Созданные для файлов потоки должны быть закрыты.
6. Не используй статические переменные.
C:\Games\file.re.part1
C:\Games\file.re.part3
C:\Games\file.re.part2
C:\Games\file.re.part11
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        ArrayList<File> list = new ArrayList<>();
        TreeSet<String> set = new TreeSet<>();
        while (true){
            s = reader.readLine();
            if(s.equals("end")) break;
           set.add(s);
        }
        reader.close();
//        Collections.sort(list, (File obj1, File obj2) ->
//        {
//            return Integer.parseInt(obj1.getName().split("part")[1]) -
//                    Integer.parseInt(obj2.getName().split("part")[1]);
//        });

        System.out.println(set);
        String fileResName = set.first().replaceAll(".part\\d+", "");

        System.out.println(fileResName);

        Iterator<String> i = set.iterator();
        BufferedOutputStream buff = new BufferedOutputStream(new FileOutputStream(fileResName, true));
        while (i.hasNext()){
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(i.next()));
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            buff.write(buffer);
            inputStream.close();

        }
        buff.close();

    }
}
