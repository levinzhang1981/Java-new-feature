package com.levinzhang.jdk12;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileMismatchDemo {
    public static void main(String[] args) throws IOException {
        File a = new File("C:\\Users\\levzh\\Desktop\\mismatch\\test.txt");
        File b = new File("C:\\Users\\levzh\\Desktop\\mismatch\\test2.txt");
        System.out.println(Files.mismatch(a.toPath(), b.toPath()));
    }
}
