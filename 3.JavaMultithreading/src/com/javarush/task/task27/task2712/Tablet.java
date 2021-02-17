package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;

import java.io.IOException;
import java.io.ObjectStreamClass;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {
    private final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());
    private Observer observer;

    public Tablet(int number) {
        this.number = number;
    }

    //создает заказ из тех блюд, которые выберет пользователь
    public Order createOrder(){
        Order order;
        try {
            order = new Order(this);
            ConsoleHelper.writeMessage(order.toString());
            if(order.isEmpty()) return null;
            setChanged();
            notifyObservers(order);
            try{
            new AdvertisementManager(order.getTotalCookingTime() * 60).processVideos();
            }catch (NoVideoAvailableException e){
                logger.log(Level.INFO, "No video is available for the order " + order);
            }

            return order;
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    return null;}

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}
