package com.javarush.task.task18.task1822;

import java.io.*;

/* 
Поиск данных внутри файла
Поиск данных внутри файла
Считать с консоли имя файла.
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int).
Закрыть потоки.
В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity
где id - int.
productName - название товара, может содержать пробелы, String.
price - цена, double.
quantity - количество, int.
Информация по каждому товару хранится в отдельной строке.
Требования:
1. Программа должна считать имя файла с консоли.
2. Создай для файла поток для чтения.
3. Программа должна найти в файле и вывести информацию о id, который передается первым параметром.
4. Поток для чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        //String testFile = "C:\\Games\\file1.txt";
        int id = Integer.parseInt(args[0]);
        FileInputStream inputStream = new FileInputStream(file);
        BufferedReader buff = new BufferedReader(new InputStreamReader(inputStream));
        String s;
        String[] resAr;
        while ((s = buff.readLine()) != null){
            resAr = s.split(" ");
            if (resAr[0].equals(String.valueOf(id))) {
                for(int i = 0; i < resAr.length; i++){
                    System.out.print(resAr[i] + " ");
                }
            }
        }
        buff.close();
    }
}
