package com.levinzhang.jdk20;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class VirtualThreadPerformanceDemo {
    public static void main(String[] args) throws InterruptedException {
        final AtomicInteger atomicInteger = new AtomicInteger();
        CountDownLatch countDownLatch = new CountDownLatch(10000);
        Runnable runnable = () -> {
            try {
                Thread.sleep(Duration.ofSeconds(1));
            } catch(Exception e) {
                System.out.println(e);
            }finally {
                countDownLatch.countDown();
            }
            System.out.println("Work Done - " + atomicInteger.incrementAndGet());
        };

        Instant start = Instant.now();

        //try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
        try (var executor = Executors.newFixedThreadPool(100)) {
            for(int i = 0; i < 10_000; i++) {
                executor.submit(runnable);
            }
        }
        countDownLatch.await();
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();  //in millis
        System.out.println("Total elapsed time : " + timeElapsed);
    }
}
