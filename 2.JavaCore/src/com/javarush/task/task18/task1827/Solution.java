package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы
CrUD для таблицы внутри файла.
Считать с консоли имя файла для операций CrUD.

Программа запускается со следующим набором параметров:
-c productName price quantity

Значения параметров:
где id - 8 символов.
productName - название товара, 30 символов.
price - цена, 8 символов.
quantity - количество, 4 символа.
-c - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно,
инкрементируя максимальный id, найденный в файле.

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity

Данные дополнены пробелами до их длины.

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234


Требования:
1. Программа должна считать имя файла для операций CrUD с консоли.
2. В классе Solution не должны быть использованы статические переменные.
3. При запуске программы без параметров список товаров должен остаться неизменным.
4. При запуске программы с параметрами "-c productName price quantity" в конец файла должна добавится новая строка с товаром.
5. Товар должен иметь следующий id, после максимального, найденного в файле.
6. Форматирование новой строки товара должно четко совпадать с указанным в задании.
7. Созданные для файлов потоки должны быть закрыты.
C:\\Games\\file1.txt
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        if(args.length==0){
            return;
        }
        else if(args[0].equals("-c")){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileInputStream inputStream = new FileInputStream(fileName);
        reader = new BufferedReader(new InputStreamReader(inputStream));
        int maxID = 0;
        if(inputStream.available() > 0){
            while (reader.ready()){
                String s = reader.readLine().substring(0, 8).trim();
                int x = Integer.parseInt(s);
                maxID = Math.max(x, maxID);
            }
        }
        reader.close();
        maxID++;
        //System.out.println(maxID);



            PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileName, true));
            //printWriter.println();
            printWriter.println(String.format(System.lineSeparator()+"%-8d%-30s%-8.2f%-4d", maxID, args[1],
                    Float.parseFloat(args[2]), Integer.parseInt(args[3])));

            printWriter.close();
        }
    }
}
