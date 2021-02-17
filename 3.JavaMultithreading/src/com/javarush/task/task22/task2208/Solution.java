package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
1. Метод getQuery должен принимать один параметр типа Map.
2. Метод getQuery должен иметь тип возвращаемого значения String.
3. Метод getQuery должен быть статическим.
4. Метод getQuery должен возвращать строку сформированную по правилам описанным в условии задачи
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivanov");
        map.put("city", "NN");
        map.put("age", "876");
        System.out.println(getQuery(map));

    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder result = new StringBuilder("");
        Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> entry = iterator.next();
            if(entry.getValue() == null) continue;
            result.append(entry.getKey()).append(" = ").append("'").append(entry.getValue()).append("'");
            if(iterator.hasNext()) result.append(" and ");
        }
        String res = result.toString();
        if(res.endsWith(" and ")) res = res.substring(0, res.length() - 5);
        return res;
    }
}
