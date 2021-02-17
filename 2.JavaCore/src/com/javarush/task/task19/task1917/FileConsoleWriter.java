package com.javarush.task.task19.task1917;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

/* 
Свой FileWriter
Реализовать логику FileConsoleWriter.
Класс FileConsoleWriter должен содержать приватное поле FileWriter fileWriter.
Класс FileConsoleWriter должен содержать все конструкторы, которые инициализируют fileWriter для записи.
Класс FileConsoleWriter должен содержать пять методов write и один метод close:

public void write(char[] cbuf, int off, int len) throws IOException
public void write(int c) throws IOException
public void write(String str) throws IOException
public void write(String str, int off, int len) throws IOException
public void write(char[] cbuf) throws IOException
public void close() throws IOException
При записи данных в файл, должен дублировать эти данные на консоль.


Требования:
1. Класс FileConsoleWriter должен содержать приватное поле FileWriter fileWriter,
которое не должно быть сразу проинициализировано.
2. Класс FileConsoleWriter должен иметь пять конструкторов которые инициализируют fileWriter для записи.
3. Класс FileConsoleWriter должен содержать метод write(char[] cbuf, int off, int len) throws IOException,
 в котором данные для записи должны записываться в fileWriter и дублироваться в консоль.
4. Класс FileConsoleWriter должен содержать метод write(int c) throws IOException,
в котором данные для записи должны записываться в fileWriter и дублироваться в консоль.
5. Класс FileConsoleWriter должен содержать метод write(String str) throws IOException,
 в котором данные для записи должны записываться в fileWriter и дублироваться в консоль.
6. Класс FileConsoleWriter должен содержать метод write(String str, int off, int len) throws IOException,
 в котором данные для записи должны записываться в fileWriter и дублироваться в консоль.
7. Класс FileConsoleWriter должен содержать метод write(char[] cbuf) throws IOException,
в котором данные для записи должны записываться в fileWriter и дублироваться в консоль.
8. Класс FileConsoleWriter должен содержать метод close() throws IOException,
в котором должен вызываться такой же метод поля fileWriter.
*/

public class FileConsoleWriter {
    private FileWriter fileWriter;



    public FileConsoleWriter(String fileName) throws IOException {
        this.fileWriter=new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        this.fileWriter = new FileWriter(fileName,append);

    }

    public FileConsoleWriter(File file) throws IOException {
        this.fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        this.fileWriter = new FileWriter(file,append);


    }

    public FileConsoleWriter(FileDescriptor fd) {
        this.fileWriter =new FileWriter(fd);
    }


    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        for(int i = off; i < off+len; i++){
            System.out.print(cbuf[i]);
        }
    }
    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        for(char c: cbuf){
            System.out.print(c);
        }
    }
    public void write(int c) throws IOException {
        fileWriter.write(c);
        System.out.print(c);
    }
    public void write(String s) throws IOException {
        fileWriter.write(s);
        System.out.print(s);
    }
    public void write(String s, int off, int len) throws IOException {
        fileWriter.write(s, off, len);
        System.out.print(s.substring(off, off+len));
    }
    public void close() throws IOException {
        fileWriter.close();
    }

    public static void main(String[] args) {

    }

}
