package com.javarush.task.task25.task2504;

/* 
Switch для нитей
Требования:
1. Метод processThreads принимает аргументом массив нитей.
2. Если переданная нить не запущена, нужно ее запустить.
3. Если переданная нить находится в ожидании, нужно ее прервать.
4. Если переданная нить работает, то нужно проверить маркер isInterrupted.
5. Если переданная нить завершила работу, нужно вывести в консоль ее приоритет.
6. Метод processThreads должен использовать оператор switch.
*/

public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        for(Thread thread: threads){
            switch (thread.getState()){
                case NEW:
                    thread.start();
                    break;
                case BLOCKED:
                    thread.interrupt();
                    break;
                case WAITING:
                    thread.interrupt();
                break;
                case TIMED_WAITING:
                    thread.interrupt();
                    break;
                case RUNNABLE:
                    thread.isInterrupted();
                    break;
                case TERMINATED:
                    System.out.println(thread.getPriority());
                    break;
            }
        }
    }

    public static void main(String[] args) {
    }
}
