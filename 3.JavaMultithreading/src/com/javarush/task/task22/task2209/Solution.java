package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/* 
Составить цепочку слов
1. Метод main должен считывать имя файла с клавиатуры.
2. В классе Solution не должно быть статических полей.
3. В методе getLine должен быть использован StringBuilder.
4. Метод getLine должен возвращать пустую строку (пустой StringBuilder) в случае если ему не были переданы параметры (слова).
5. Метод getLine не должен изменять переданные ему параметры (слова).
6. Все слова переданные в метод getLine должны быть включены в результирующую строку.
7. Вывод на экран должен соответствовать условию задачи.
C://Games//file1.txt
*/

public class Solution {
    public static void main(String[] args) {
        //...
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader bufferedReader = new BufferedReader(new FileReader(reader.readLine()))){
            StringBuilder stringBuilder = new StringBuilder();
            while (bufferedReader.ready()){
                stringBuilder.append(bufferedReader.readLine()).append(" ");
            }
            String[] cities = stringBuilder.toString().split(" ");
            System.out.println(Arrays.toString(cities));

            String firstWord;
            for(int i = 0; i < cities.length; i++){
                for(int j = cities.length - 1; j > i; j--){

                }

            }




        }catch (IOException e){
                e.printStackTrace();
        }



        //StringBuilder result = getLine();
        //System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder builder = new StringBuilder();
        if(words == null) return builder;
        for(String s: words){
            builder.append(s);
        }
        return builder;
    }
}
