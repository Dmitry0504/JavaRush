package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        //this.setDaemon(true);
    }

    @Override
    public void run() {
        Thread.State state = thread.getState();
        System.out.println(state);
        while (true){
            if(state != thread.getState()){
                state = thread.getState();
                System.out.println(state);
            }
            if(state == State.TERMINATED) return;
        }
    }
}
