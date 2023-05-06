package com.levinzhang.jdk20;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class VirtualThreadBuildDemo {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("Init Virtual Thread");
        Thread virtualThread = Thread.ofVirtual().start(runnable);

        Runnable runnable2 = () -> System.out.println("Init Virtual Thread with builder");
        Thread.Builder builder = Thread.ofVirtual().name("JVM-Thread");
        Thread t2_1 = builder.start(runnable2);
        Thread t2_2 = builder.start(runnable2);

        Runnable runnable3 = () -> System.out.println("Lazy Start");
        Thread virtualThread3 =  Thread.ofVirtual().unstarted(runnable3);
        virtualThread3.start();


        // Init Virtual Thread by Executor, each job will have a Virtual Thread
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, 10_000).forEach(i -> {
                executor.submit(() -> {
                    Thread.sleep(Duration.ofSeconds(1));
                    return i;
                });
            });
        }
    }
}
