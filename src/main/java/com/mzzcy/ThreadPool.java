package com.mzzcy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ThreadPool {

    private static ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {

        executorService.execute(() -> {

            System.out.println("begin running!");
        });

        ThreadFactory threadFactory = Executors.defaultThreadFactory();


    }
}
