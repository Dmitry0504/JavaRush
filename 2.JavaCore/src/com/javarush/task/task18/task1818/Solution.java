package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
Считать с консоли 3 имени файла.
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла.
Закрыть потоки.
Требования:
1. Программа должна три раза считать имена файлов с консоли.
2. Для первого файла создай поток для записи. Для двух других - потоки для чтения.
3. Содержимое второго файла нужно переписать в первый файл.
4. Содержимое третьего файла нужно дописать в первый файл (в который уже записан второй файл).
5. Созданные для файлов потоки должны быть закрыты.
C:\Games\file1.txt
C:\Games\file2.txt
C:\Games\file3.txt
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream input = new FileOutputStream(reader.readLine());
        FileInputStream out2 = new FileInputStream(reader.readLine());
        FileInputStream out3 = new FileInputStream(reader.readLine());
        while (out2.available() > 0){
            input.write(out2.read());
        }
        while (out3.available() > 0){
            input.write(out3.read());
        }
        input.close();
        out2.close();
        out3.close();
    }
}
