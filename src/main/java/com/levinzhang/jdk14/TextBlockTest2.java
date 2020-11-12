package com.levinzhang.jdk14;

public class TextBlockTest2 {
    public static void main(String[] args) {
        String output = """
                Name: %s
                Phone: %d
                Salary: $%.2f
                """.formatted("Pankaj", 123456789, 2000.5555);

        System.out.println(output);


        String htmlTextBlock = "<html>   \n" +
                "\t<body>\t\t \n" +
                "\t\t<p>Hello</p>  \t \n" +
                "\t</body> \n" +
                "</html>";
        System.out.println(htmlTextBlock.replace(" ", "*"));
        System.out.println(htmlTextBlock.stripIndent().replace(" ", "*"));
        
    }
}
