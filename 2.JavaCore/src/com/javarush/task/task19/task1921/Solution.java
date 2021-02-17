package com.javarush.task.task19.task1921;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String.
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами.
Заполнить список PEOPLE используя данные из файла.
Закрыть потоки.
Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013

Требования:
1. Класс Solution должен содержать публичную константу PEOPLE типа List<Person>,
которая должна быть сразу проинициализирована.
2. Программа НЕ должна считывать данные с консоли.
3. Программа должна считывать содержимое файла (используй FileReader).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна заполнить список PEOPLE данными из файла.
6. Программа должна правильно работать с двойными именами, например Анна-Надежда.
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String s;
        DateFormat df = new SimpleDateFormat("dd MM yyyy");
        Date bd;
        while (reader.ready()){
            s = reader.readLine();
            String[] array = s.split(" ");
            String birthDate = "";
            String name = "";
            for(int i = array.length - 3; i < array.length; i++){
                birthDate += array[i] + " ";
            }
            bd = df.parse(birthDate);
            for(int i = 0; i < array.length - 3; i++){
                name += array[i] + " ";
            }
            name = name.trim();
            PEOPLE.add(new Person(name, bd));
        }
        reader.close();
    }
    
}
