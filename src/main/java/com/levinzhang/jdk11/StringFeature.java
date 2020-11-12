package com.levinzhang.jdk11;

public class StringFeature {
    public static void main(String[] args) {
        String a = "Kingland \n" +
                "is\n" +
                "a\n" +
                "good\n" +
                "company.";
//        String[] lines = a.split("\n");
//        for (String line : lines) {
//            System.out.println(line);
//        }
        a.lines().forEach(System.out::println);

        // isBlank, indent
    }
}