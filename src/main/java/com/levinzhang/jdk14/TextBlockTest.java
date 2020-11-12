package com.levinzhang.jdk14;

public class TextBlockTest {
    public static void main(String[] args) {
        String text = """
                Did you know \
                Java 14 \
                has the most features among\
                all non-LTS versions so far\
                """;
        
        String text2 = "Did you know " +
                "Java 14 " +
                "has the most features among" +
                " all non-LTS versions so far";
        System.out.println(text);
        System.out.println(text2);
    }
}
