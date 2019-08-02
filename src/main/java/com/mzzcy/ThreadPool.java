package com.mzzcy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ThreadPool {

    private static ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {

        int a = -1;

        executorService.execute(() -> {

            System.out.println("begin running!");
        });

        ThreadFactory threadFactory = Executors.defaultThreadFactory();

        Thread myThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getThreadGroup().getName() + " " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        myThread.setDaemon(true);
        myThread.start();

        Thread myThread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread() + " " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        myThread2.setDaemon(false);
        myThread2.start();

        System.out.println(Thread.currentThread().getName() + " is DONE");
    }
}
