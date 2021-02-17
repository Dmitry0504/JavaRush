package com.javarush.task.task21.task2113;

import java.util.ArrayList;
                                                  
import java.util.List;
public class Hippodrome {
    static Hippodrome game;
    private List<Horse> horses;
                                                  
    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }
   
    public void run (){
        for(int i = 0; i < 100; i++){
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("Sleep not sleep");
            }
        }
    }

    public void move (){
        List<Horse> list = getHorses();
        for(Horse h: list){
            h.move();
        }
    }

    public void print (){
        List<Horse> list = getHorses();
        for(Horse h: list){
            h.print();
        }
        for(int i = 0; i < 10; i++){
            System.out.println();
        }

    }

    public Horse getWinner(){
        double max_distance = 0;
        for(Horse h: horses){
            if(h.getDistance() > max_distance) max_distance = h.getDistance();
        }
        for(Horse h: horses){
            if (h.getDistance() == max_distance) return h;
        }
        return null;
    }

    public void printWinner(){
        System.out.printf("Winner is %s!", getWinner().getName());
    }
                                                  
    public static void main(String[] args) {
        List<Horse> horseList = new ArrayList<>();
        Horse horse1 = new Horse("Vaska", 3.0, 0);
        Horse horse2 = new Horse("Maska", 3.0, 0);
        Horse horse3 = new Horse("Bucefal", 3.0, 0);
        horseList.add(horse1);
        horseList.add(horse2);
        horseList.add(horse3);
        game = new Hippodrome(horseList);
        game.run();
        game.printWinner();
                                                  
    }
                                                  
}