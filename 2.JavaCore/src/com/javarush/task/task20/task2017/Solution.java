package com.javarush.task.task20.task2017;

import java.io.*;

/* 
Десериализация
На вход подается поток, в который записан сериализованный объект класса A либо класса B.
Десериализуй объект в методе getOriginalObject так, чтобы в случае возникновения исключения
было выведено сообщение на экран и возвращен null.
Реализуй интерфейс Serializable где необходимо.

Требования:
1. Класс B должен быть потомком класса A.
2. Класс A должен поддерживать интерфейс Serializable.
3. Класс B не должен явно поддерживать интерфейс Serializable.
4. Метод getOriginalObject должен возвращать объект типа A полученный из потока ObjectInputStream.
5. Метод getOriginalObject должен возвращать null, если при попытке десериализации не был получен объект типа A.
6. Метод getOriginalObject должен возвращать null, если при попытке десериализации возникло исключение.
*/
public class Solution implements Serializable{
    A a = new A();
    B b = new B();
    public A getOriginalObject(ObjectInputStream objectStream) {
        try{
            Object object = objectStream.readObject();

            return (A) object;
        }catch (Exception e){
            //System.out.println("Class not found");
            return null;
        }

    }

    public class A implements Serializable{
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public void _writeObject(Object o, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(o);
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("C:\\Games\\save.ser"));
        solution._writeObject(solution.a, objectOutputStream);
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("C:\\Games\\save.ser"));

        solution.getOriginalObject(objectInputStream);



    }
}
