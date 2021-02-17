package com.javarush.task.task17.task1711;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        String name;
        Sex sex;
        Date bd;
        Person p;
        int id;
        SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        switch (args[0]){
            case "-c":
                synchronized (allPeople){
                for(int i = 1; i < args.length; i = i + 3){
                name = args[i];
                sex = (args[i+1].equals("м"))? Sex.MALE : Sex.FEMALE;
                bd = format1.parse(args[i+2]);
                if(sex == Sex.MALE) p = Person.createMale(name, bd);
                else p = Person.createFemale(name, bd);
                allPeople.add(p);
                System.out.println(allPeople.indexOf(p));}
                }
                break;
            case "-u":
                synchronized (allPeople){
                for(int i = 1; i < args.length; i = i + 4){
                id = Integer.parseInt(args[i]);
                if(id >= 0 & id < allPeople.size()){
                p = allPeople.get(id);
                name = args[i+1];
                sex = (args[i+2].equals("м"))? Sex.MALE : Sex.FEMALE;
                bd = format1.parse(args[i+3]);
                p.setName(name);
                p.setBirthDate(bd);
                p.setSex(sex);}
                }
                }
                break;
            case "-d":
                synchronized (allPeople){
                for(int i = 1; i < args.length; i++){
                    id = Integer.parseInt(args[i]);
                    if(id >= 0 & id < allPeople.size()){
                p = allPeople.get(id);
                p.setSex(null);
                p.setBirthDate(null);
                p.setName(null);}}}
                break;
            case "-i":
                synchronized (allPeople){
                for(int i = 1; i < args.length; i++){
                    id = Integer.parseInt(args[i]);
                    p = allPeople.get(id);
                    name = p.getName();
                    bd = p.getBirthDate();
                    sex = p.getSex();
                    String s = (sex == Sex.MALE) ? "м": "ж";
                    System.out.println(name + " " + s + " " + format2.format(bd));
                }}
                break;

        }

    }
}
