package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Сериализация под запретом
Запрети сериализацию класса SubSolution используя NotSerializableException.
Сигнатуры классов менять нельзя.

Требования:
1. Класс Solution должен поддерживать интерфейс Serializable.
2. Класс SubSolution должен быть создан внутри класса Solution.
3. Класс SubSolution должен быть потомком класса Solution.
4. При попытке сериализовать объект типа SubSolution должно возникать исключение NotSerializableException.
5. При попытке десериализовать объект типа SubSolution должно возникать исключение NotSerializableException.
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {
        private void writeObject(ObjectOutputStream out) throws IOException{

            throw new NotSerializableException();
        }

        private void readObject(ObjectInputStream in) throws NotSerializableException {

            throw new NotSerializableException();
        }

    }

    public static void main(String[] args)  {
        SubSolution subSolution = new SubSolution();
        FileOutputStream outputStream = null;
        SubSolution subSolution1 = null;
        try{
            outputStream = new FileOutputStream("C:\\Games\\save.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(subSolution);
            outputStream.close();
            objectOutputStream.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        FileInputStream inputStream;
        try{
           inputStream = new FileInputStream("C:\\Games\\save.ser");
           ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
           Object object = objectInputStream.readObject();
           subSolution1 = (SubSolution) object;
           inputStream.close();
           objectInputStream.close();
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        System.out.println(subSolution);
        System.out.println(subSolution1);

    }
}
