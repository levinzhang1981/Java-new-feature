package com.levinzhang.jdk10;

import java.util.ArrayList;

public class VarTest {
    public static void main(String[] args) {
        var a = "ss";
        System.out.println(a);
        var list = new ArrayList<String>();
        list.add("Kingland");
        list.add("Platform");
        var stream = list.stream();
        stream.forEach(System.out::println);
    }

//    public static String test(var a, var b) {
//
//    }
}
