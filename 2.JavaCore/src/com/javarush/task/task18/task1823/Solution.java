package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit".
Передайте имя файла в нить ReadThread.
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки.
Требования:
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "exit".
2. Для каждого файла создай нить ReadThread и запусти ее.
3. После запуска каждая нить ReadThread должна создать свой поток для чтения из файла.
4. Затем нити должны найти максимально встречающийся байт в своем файле и добавить его в словарь resultMap.
5. Поток для чтения из файла в каждой нити должен быть закрыт.
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (!((s = reader.readLine()).equals("exit"))){
            new ReadThread(s).start();
        }
        //System.out.println(resultMap);
    }

    public static class ReadThread extends Thread {
        String filename;
        public ReadThread(String fileName) {
            //implement constructor body
            //super();
            this.filename = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            super.run();
            int[] array = new int[256];
            int i;
            int c = 0;
            int maxByte= 0;
            String resByte;
            try {
                FileInputStream input = new FileInputStream(this.filename);
                while (input.available() > 0){
                    i = input.read();
                    array[i]++;
                }
                for(int j = 0; j < array.length; j++){
                    if(array[j] > maxByte) {
                        maxByte = array[j];
                        c = j;
                    }
                }
                //resByte = String.valueOf(c);
                resultMap.put(filename, c);
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
