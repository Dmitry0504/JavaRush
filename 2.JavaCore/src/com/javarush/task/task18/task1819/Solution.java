package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.ArrayList;


/*
Объединение файлов
Считать с консоли 2 имени файла.
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов.
Закрыть потоки.
Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Не используй в программе статические переменные.
3. Для первого файла создай поток для чтения и считай его содержимое.
4. Затем, для первого файла создай поток для записи(поток для записи должен быть один). Для второго - для чтения.
5. Содержимое первого и второго файла нужно объединить в первом файле.
6. Сначала должно идти содержимое второго файла, затем содержимое первого.
7. Созданные для файлов потоки должны быть закрыты.
C:\Games\file1.txt
C:\Games\file2.txt
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        ArrayList<Byte> res = new ArrayList<>();

        FileInputStream input2 = new FileInputStream(file2);
        FileInputStream input1 = new FileInputStream(file1);
        while (input2.available()>0){
            res.add((byte) input2.read());
        }
        System.out.println(res);
        while (input1.available()>0){
            res.add((byte) input1.read());
        }
        System.out.println(res);

        FileOutputStream out = new FileOutputStream(file1);
        for(Byte x: res){
            out.write(x);
        }

        input1.close();
        input2.close();
        out.close();
    }
}
