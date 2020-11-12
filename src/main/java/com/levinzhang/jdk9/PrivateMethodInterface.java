package com.levinzhang.jdk9;

public interface PrivateMethodInterface {
    private void test() {
        System.out.println("This is private method in interface");
    }

    default void testDefault() {
        System.out.println("This is default method in interface");
        test();
    }
}
