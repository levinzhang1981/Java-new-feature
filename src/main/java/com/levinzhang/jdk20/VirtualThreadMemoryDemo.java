package com.levinzhang.jdk20;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class VirtualThreadMemoryDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10000);
        final AtomicInteger atomicInteger = new AtomicInteger();
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
        //var executor = Executors.newFixedThreadPool(3000);
        var executor = Executors.newVirtualThreadPerTaskExecutor();
        for(int i = 0; i < 10000; i++) {
            executor.submit(runnable);
        }
        countDownLatch.await();
        System.out.println("The total memory is:"+Runtime.getRuntime().totalMemory()/(1024*1024)+"M");
        System.out.println("The used memory is:"+(Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())/(1024*1024)+"M");
        executor.close();
        System.out.println("-------Finished------");
    }
}
