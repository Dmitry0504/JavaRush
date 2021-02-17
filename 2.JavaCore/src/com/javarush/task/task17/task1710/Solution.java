package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
1. Класс Solution должен содержать public static поле allPeople типа List<Person>.
2. Класс Solution должен содержать статический блок, в котором добавляются два человека в список allPeople.
3. При запуске программы с параметром -с программа должна добавлять человека с заданными параметрами в
конец списка allPeople, и выводить id (index) на экран.
4. При запуске программы с параметром -u программа должна обновлять данные человека с заданным id в списке allPeople.
5. При запуске программы с параметром -d программа должна логически удалять человека с заданным id в списке allPeople.
6. При запуске программы с параметром -i программа должна выводить на экран данные о человеке с заданным id
по формату указанному в задании.
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        String name;
        Date birthdate;
        Sex sex;
        int id;
        Person p;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        if (args[0].equals("-c")){
            name = args[1];
            sex = (args[2].equals("м")) ? Sex.MALE : Sex.FEMALE;
            birthdate = format.parse(args[3]);
            if(sex == Sex.MALE) p = Person.createMale(name, birthdate);
            else p = Person.createFemale(name, birthdate);
            allPeople.add(p);
            System.out.println(allPeople.indexOf(p));
        }
        if (args[0].equals("-u")){
            id = Integer.parseInt(args[1]);
            name = args[2];
            sex = (args[3].equals("м")) ? Sex.MALE : Sex.FEMALE;
            birthdate = format.parse(args[4]);
            p = allPeople.get(id);
            p.setName(name);
            p.setSex(sex);
            p.setBirthDate(birthdate);
        }
        if (args[0].equals("-d")){
            id = Integer.parseInt(args[1]);
            p = allPeople.get(id);
            p.setBirthDate(null);
            p.setSex(null);
            p.setName(null);
        }
        if (args[0].equals("-i")){
            id = Integer.parseInt(args[1]);
            p = allPeople.get(id);
            name = p.getName();
            String s = (p.getSex() == Sex.MALE) ? "м" : "ж";
            System.out.println(name + " " + s + " " + format2.format(p.getBirthDate()));
        }


    }
}
