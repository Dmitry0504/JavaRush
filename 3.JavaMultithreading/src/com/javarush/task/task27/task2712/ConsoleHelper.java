package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {


    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        writeMessage(Dish.allDishesToString());
        writeMessage("Выберите блюдо:");
        List<Dish> list = new ArrayList<>();
        String order;
        while (!(order = readString()).equals("exit")){
            try {
                list.add(Dish.valueOf(order));
            }catch (Exception e){
                writeMessage("Такого блюда нет");
            }
        }
        return list;
    }

}
