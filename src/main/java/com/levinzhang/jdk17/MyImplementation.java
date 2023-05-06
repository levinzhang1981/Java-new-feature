package com.levinzhang.jdk17;

public final class MyImplementation implements MyInterface {
    @Override
    public void sayHello() {
        System.out.println("Hello sealed interface");
    }
}
