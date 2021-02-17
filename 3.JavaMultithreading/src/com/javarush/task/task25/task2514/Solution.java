package com.javarush.task.task25.task2514;

/* 
Первый закон Финэйгла: если эксперимент удался, что-то здесь не так...
*/

public class Solution {
    public static class YieldRunnable implements Runnable {
        private int index;

        public YieldRunnable(int index) {
            this.index = index;
        }

        public void run() {
            System.out.println("begin-" + index);
            Thread.yield();
            System.out.println("end-" + index);
        }
    }

    public static void main(String[] args) {
//        YieldRunnable thread1 = new YieldRunnable(1);
//        YieldRunnable thread2 = new YieldRunnable(2);
//        YieldRunnable thread3 = new YieldRunnable(3);
//        YieldRunnable thread4 = new YieldRunnable(4);
//        new Thread(thread1).start();
//        new Thread(thread2).start();
//        new Thread(thread3).start();
//        new Thread(thread4).start();
    }
}
