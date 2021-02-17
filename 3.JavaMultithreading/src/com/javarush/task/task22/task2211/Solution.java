package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/* 
Смена кодировки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Charset utf8 = StandardCharsets.UTF_8;
        Charset windows1251 = Charset.forName("Windows-1251");


        byte[] buff = Files.readAllBytes(Paths.get(args[0]));
        String s = new String(buff, windows1251);

        FileOutputStream outputStream = new FileOutputStream(args[1]);
        buff = s.getBytes(utf8);
        outputStream.write(buff);


        outputStream.close();


    }
}
