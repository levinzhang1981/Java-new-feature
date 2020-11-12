package com.levinzhang.jdk9;

public class PrivateMethodInterfaceMain {
    public static void main(String[] args) {
        PrivateMethodInterfaceImpl impl =
                new PrivateMethodInterfaceImpl();
        impl.testDefault();
    }
}
