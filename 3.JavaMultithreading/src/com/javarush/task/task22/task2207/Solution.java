package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
1. Метод main должен считывать имя файла с клавиатуры.
2. В методе main должен быть использован StringBuilder.
3. В классе Solution должен содержаться вложенный класс Pair с методами equals, hashCode и toString.
Удалять или изменять эти методы нельзя.
4. В классе Pair должен быть объявлен конструктор без параметров (или конструктор по умолчанию).
5. Список result должен быть заполнен корректными парами согласно условию задачи.
C:\\Games\\new 1.txt
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fr = new FileReader(reader.readLine());

        int data = fr.read();

        StringBuilder stringBuilder = new StringBuilder();

        while (data != -1){
            stringBuilder.append((char) data);
            data = fr.read();
        }

        String[] strings = stringBuilder.toString().replaceAll("\\R", " ").split(" ");

        for(int i = 0; i < strings.length; i++){
            for(int j = 1; j < strings.length; j++){
                if(i != j & strings[i] != null & strings[j] != null & (strings[i] != null && strings[i].equals(strings[j]))){
                    Pair pair = new Pair();
                    pair.first = strings[i];
                    pair.second = strings[j];
                    result.add(pair);
                    System.out.println(pair);
                    strings[i] = null;
                    strings[j] = null;
                } else if(i != j & strings[i] != null & strings[j] != null){
                    StringBuilder stringBuilder1 = new StringBuilder(strings[i]);

                    if(stringBuilder1.reverse().toString().equals(strings[j])){
                        Pair pair = new Pair();
                        pair.first = strings[i];
                        pair.second = strings[j];
                        result.add(pair);
                        System.out.println(pair);
                        strings[i] = null;
                        strings[j] = null;
                    }
                }
            }
        }


    }

    public static class Pair {
        String first;
        String second;

        public Pair(){}

//        public Pair(String first, String second) {
//            this.first = first;
//            this.second = second;
//        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
