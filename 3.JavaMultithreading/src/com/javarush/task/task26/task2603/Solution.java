package com.javarush.task.task26.task2603;

import java.util.Comparator;

/* 
Убежденному убеждать других не трудно
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class CustomizedComparator<T> implements Comparator<T>{
        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T>... comparators){
            this.comparators = comparators;
//            if(comparators != null){
//                for(int i = 0; i < comparators.length; i++){
//                    if(comparators[i] != null){
//                        this.comparators[i] = comparators[i];
//                    }
//                }
//            }
        }

        public int compare(Object o1, Object o2){
            int res = 0;
            for(Comparator comparator: comparators){
                res = comparator.compare(o1, o2);
                if(res != 0) return res;
            }
            return res;
        }

    }
}
