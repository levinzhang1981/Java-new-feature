package com.levinzhang.jdk14;

public class RecordClassTest {
    public static void main(String[] args) {
        var point = new Point(3, 5);
        System.out.println(point.x());
        System.out.println(point.hashCode());
        System.out.println(point.toString());
    }
}


record Point(int x, int y) {

}