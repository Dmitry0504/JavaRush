package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        ArrayList<Byte> list = new ArrayList<>();
        HashMap<Byte, Integer> res = new HashMap<>();
        while (fis.available() > 0){
            list.add((byte) fis.read());
        }
        //       byte[] array = fis.readAllBytes();
//        for(int i = 0; i < array.length; i++){
//            list.add(array[i]);
//        }
//        Collections.sort(list);

        for (int i = 0; i < list.size(); i ++){
            int x = Collections.frequency(list, list.get(i));
            res.put(list.get(i), x);
        }

        for(Map.Entry<Byte, Integer> entry: res.entrySet()) {
            // get key
            Byte key = entry.getKey();
            // get value
            Integer value = entry.getValue();
            if(value.equals(Collections.min(res.values()))) System.out.print(key + " ");
        }
//        System.out.println();
//        System.out.println(res);
        reader.close();
        fis.close();
        //C:\Games\int.txt
    }
}

