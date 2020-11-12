package com.levinzhang.jdk14;

public class Student extends Person {
    public int grade;

    public Student(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
