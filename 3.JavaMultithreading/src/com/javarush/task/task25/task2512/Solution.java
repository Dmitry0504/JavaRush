package com.javarush.task.task25.task2512;

import java.util.LinkedList;
import java.util.List;

/* 
Живем своим умом
*/

public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        LinkedList<Throwable> list = new LinkedList<>();
        for(Throwable err = e; err != null; err = err.getCause()){
            list.push(err);
        }
        list.forEach(System.out :: println);
    }

    public static void main(String[] args) {
    }
}
