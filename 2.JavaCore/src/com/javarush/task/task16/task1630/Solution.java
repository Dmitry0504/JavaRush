package com.javarush.task.task16.task1630;

import java.io.*;

/* 
Последовательный вывод файлов
1. Статический блок класса Solution должен считывать с консоли имена двух файлов и сохранять
 их в переменные firstFileName и secondFileName.
2. Объяви в классе Solution public static класс ReadFileThread.
3. Класс ReadFileThread должен реализовывать интерфейс ReadFileInterface.
4. Класс ReadFileThread должен быть унаследован от подходящего класса.
5. Метод run класса ReadFileThread должен считывать строки из файла,
установленного методом setFileName. А метод getFileContent, этого же класса, должен возвращать вычитанный контент.
 Возвращаемое значение - это одна строка, состоящая из строк файла, разделенных пробелами.
6. Метод systemOutPrintln должен вызывать метод join у созданного объекта f.
7. Вывод программы должен состоять из 2х строк. Каждая строка - содержимое одного файла.
*/

public class Solution {
    public static String firstFileName;
    public static String secondFileName;
    public static String filename;
    public static String fileContent = "";

    //add your code here - добавьте код тут
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface{

        @Override
        public void setFileName(String fullFileName) {
            filename = fullFileName;
        }

        @Override
        public String getFileContent() {
            String s = fileContent;
            fileContent = "";
            return s;
        }

//        @Override
//        public void join() throws InterruptedException {
//
//        }

//        @Override
//        public void start() {
//
//        }

        @Override
        public void run() {
            try {
                BufferedReader read = new BufferedReader(new FileReader(new File(filename)));
                while (read.ready()){
                    fileContent = fileContent + read.readLine() + " ";
                }
                read.close();
            } catch (Exception e) {
                System.out.println("error");
            }

        }
    }
}
