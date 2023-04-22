package com.levinzhang.jdk20;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class VirtualThreadDemo {

    public static ThreadLocal<Integer> TEST_THREAD_LOCAL = new ThreadLocal<>();

    public static void main(String[] args) {
//        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
//            IntStream.range(0, 10_000).forEach(i -> {
//                executor.submit(() -> {
//                    Thread.sleep(Duration.ofSeconds(1));
//                    return i;
//                });
//            });
//        }
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, 10).forEach(i -> {
                executor.submit(() -> {
                    TEST_THREAD_LOCAL.set(i);
                    Thread.sleep(Duration.ofSeconds(1));
                    System.out.println("The Virtual Thread "+i+"; The Thread Local value is: "+TEST_THREAD_LOCAL.get());
                    return i;
                });
            });
        }
    }
}
