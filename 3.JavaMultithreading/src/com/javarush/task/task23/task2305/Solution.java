package com.javarush.task.task23.task2305;

/* 
Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.
Требования:
1. В классе Solution должен быть реализован метод getTwoSolutions.
2. Метод getTwoSolutions должен быть статическим.
3. Метод getTwoSolutions должен быть публичным.
4. Метод getTwoSolutions должен возвращать массив типа Solution заполненный согласно заданию.
*/

public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution solution1 = new Solution();
        InnerClass innerClass1 = solution1. new InnerClass();
        InnerClass innerClass2 = solution1. new InnerClass();
        solution1.innerClasses = new InnerClass[]{innerClass1, innerClass2};
        Solution solution2 = new Solution();
        InnerClass innerClass3 = solution2. new InnerClass();
        InnerClass innerClass4 = solution2. new InnerClass();
        solution2.innerClasses = new InnerClass[]{innerClass3, innerClass4};
        return new Solution[]{solution1, solution2};
    }

    public static void main(String[] args) {

    }
}
