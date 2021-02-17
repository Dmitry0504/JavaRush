package com.javarush.task.task29.task2909.human;

import java.util.Date;

public class Student extends UniversityPerson {
    private double averageGrade;
    private Date beginningOfSession;
    private Date endOfSession;
    private int course;

    public Student(String name, int age, double averageGrade) {
        super(name, age);
        this.averageGrade = averageGrade;
    }

    public void live() {
        learn();
    }

    public void learn() {
    }

    public void incAverageGrade(double delta){
        this.setAverageGrade(getAverageGrade() + delta);
    }

    public String getPosition(){
        return "Студент";
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course){
        this.course = course;
    }

    public void setAverageGrade(double value){
        averageGrade = value;
    }

    public void setBeginningOfSession(Date date) {
        beginningOfSession =date;
    }

    public void setEndOfSession(Date date) {
        endOfSession = date;
    }

    public double getAverageGrade() {
        return averageGrade;
    }
}