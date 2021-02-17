package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать большую часть.
Закрыть потоки.


Требования:
1. Программа должна три раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файлы - FileOutputStream
3. Первую половину байт из первого файла нужно записать во второй файл.
4. Вторую половину байт из первого файла нужно записать в третий файл.
5. Потоки FileInputStream и FileOutputStream должны быть закрыты.
C:\Games\file1.txt
C:\Games\file2.txt
C:\Games\file3.txt
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file_1 = new FileInputStream(reader.readLine());
        FileOutputStream file_2 = new FileOutputStream(reader.readLine());
        FileOutputStream file_3 = new FileOutputStream(reader.readLine());
        long file1_length = file_1.available();
        long file2_length = file1_length/2 + file1_length%2;
        long i = 0;

        while (file_1.available() > 0){
            if(++i <= file2_length){
            file_2.write(file_1.read());}
            else file_3.write(file_1.read());
        }
        file_1.close();
        file_2.close();
        file_3.close();
    }
}
