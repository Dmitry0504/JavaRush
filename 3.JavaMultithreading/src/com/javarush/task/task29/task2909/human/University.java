package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class University {
    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double value) {
        //TODO:
        for(Student student: students){
            if(student.getAverageGrade() == value) return student;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        return Collections.max(students, (obj1, obj2) -> (int) (obj1.getAverageGrade() - obj2.getAverageGrade()));
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        double minGrade = getStudentWithMaxAverageGrade().getAverageGrade();
        for(Student student: students){
            if(student.getAverageGrade() < minGrade) minGrade = student.getAverageGrade();
        }
        return getStudentWithAverageGrade(minGrade);
    }

    public void expel(Student student) {
        //TODO:
        students.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
}