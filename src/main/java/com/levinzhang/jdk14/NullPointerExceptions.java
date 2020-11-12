package com.levinzhang.jdk14;

public class NullPointerExceptions {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person.getAddress().isBlank());
    }
}
