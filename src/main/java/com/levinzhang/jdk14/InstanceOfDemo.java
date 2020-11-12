package com.levinzhang.jdk14;

public class InstanceOfDemo {
    public static void main(String[] args) {
        Person person = new Student(3);
        person.setAge(25);
        person.setName("Kevin");
//        if (person instanceof Student) {
//            Student student = (Student) person;
//            System.out.println(student.getGrade());
//        }
        if (person instanceof Student student) {
            System.out.println(student.getGrade());
        }
    }
}
