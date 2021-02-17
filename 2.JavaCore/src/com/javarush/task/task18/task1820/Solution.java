package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Округление чисел
Округление чисел
Считать с консоли 2 имени файла.
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415.
Округлить числа до целых и записать через пробел во второй файл.
Закрыть потоки.
Принцип округления:
3.49 => 3
3.50 => 4
3.51 => 4
-3.49 => -3
-3.50 => -3
-3.51 => -4
Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Для первого файла создай поток для чтения. Для второго - поток для записи.
3. Считать числа из первого файла, округлить их и записать через пробел во второй.
4. Должны соблюдаться принципы округления, указанные в задании.
5. Созданные для файлов потоки должны быть закрыты.
C:\Games\file1.txt
C:\Games\file2.txt
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        FileWriter writer = new FileWriter(file2);
        ArrayList<Double> listD = new ArrayList<>();
        ArrayList<Integer> listI = new ArrayList<>();
        String s;
        BufferedReader buff = new BufferedReader(new FileReader(file1));
        while ((s = buff.readLine()) != null){
            String[] array = s.split(" ");
            for(String a: array){
                listD.add(Double.parseDouble(a));
            }
        }
        for(Double d: listD){
            listI.add((int) Math.round(d));

        }
        for(Integer i: listI){
            writer.write(i + " ");
            writer.flush();
        }
        writer.close();
        reader.close();
        buff.close();
//        System.out.println(listD);
//        System.out.println(listI);

    }
}
