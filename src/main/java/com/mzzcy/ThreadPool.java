package com.mzzcy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ThreadPool {

    private static ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {

//        int a = -1;
//        executorService.execute(() -> {
//            System.out.println("begin running!");
//        });
//        ThreadFactory threadFactory = Executors.defaultThreadFactory();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("N1");
            }
        }).start();

        new Thread() {
            @Override
            public void run() {

                System.out.println("N2");
            }
        }.start();

    }
}
