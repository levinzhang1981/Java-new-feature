package com.levinzhang.jdk17;

public sealed interface MyInterface permits MyImplementation {
    void sayHello();
}
