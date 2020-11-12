package com.levinzhang.jdk11;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class JFRTest {
    public static void main(String[] args) throws InterruptedException, IOException {
        Person person = new Person();
        person.setAge(25);
        person.setName("Kevin");
        System.out.println(person.toString());
        File a = new File("C:\\Users\\levzh\\Desktop\\mismatch\\test.txt");
        String content = Files.readString(a.toPath());
        System.out.println(content);
        new Thread(() -> {
            try {
                Thread.sleep(60 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("New Thread");
        }, "MyThread");
        Thread.sleep(60 * 1000 * 2);
    }

    public static void test() {
        System.out.println("Test");
    }
}
