package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
C:\Games\int.txt
C:\Games\result.txt
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    static {
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();
            BufferedReader readFile1 = new BufferedReader(new FileReader(fileName1));
            //       allLines = Files.readAllLines(Path.of(fileName1), StandardCharsets.UTF_8);
            String str;
            while (((str = readFile1.readLine()) != null)){
                allLines.add(str);
            }
            reader.close();
            readFile1.close();
            BufferedReader readFile2 = new BufferedReader(new FileReader(fileName2));
            String s;
            while (((s = readFile2.readLine()) != null)){
                forRemoveLines.add(s);
            }
            readFile2.close();
//            forRemoveLines = Files.readAllLines(Path.of(fileName2), Charset.forName("windows-1251"));
        }catch (IOException e) {e.printStackTrace();}
    }
    public static void main(String[] args) {

        System.out.println(allLines.containsAll(forRemoveLines));
        try {
            new Solution().joinData();
        } catch (CorruptedDataException e) {
            System.out.println("oshibochka");
        }
        System.out.println(allLines);
        System.out.println(forRemoveLines);
    }

    public void joinData() throws CorruptedDataException {
            if(allLines.containsAll(forRemoveLines)){
                allLines.removeAll(forRemoveLines);
                } else {
                allLines.clear();
                throw new CorruptedDataException();
            }
    }
}
