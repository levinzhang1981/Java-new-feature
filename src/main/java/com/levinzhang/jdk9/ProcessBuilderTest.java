package com.levinzhang.jdk9;

import java.io.IOException;

public class ProcessBuilderTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        final ProcessBuilder processBuilder = new ProcessBuilder("cmd")
                .inheritIO();
        final ProcessHandle processHandle = processBuilder.start().toHandle();

        Thread.sleep(5000);
        System.out.println(processHandle.info().startInstant().get());
        processHandle.destroyForcibly();

        processHandle.onExit().whenCompleteAsync((handle, throwable) -> {
            if (throwable == null) {
                System.out.println("---------");
                System.out.println(handle.pid());
            } else {
                throwable.printStackTrace();
            }
        });
    }
}
