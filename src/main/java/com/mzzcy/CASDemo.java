package com.mzzcy;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import sun.misc.Unsafe;

/**
 * Created by changyin.zhao on 11/7/18
 */
public class CASDemo {

    static AtomicInteger adder = new AtomicInteger(1);

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();

        service.execute(() -> {
            for (int i = 1; i <= 99; i++) {
                if (i % 2 == 1) {

                    while (!adder.compareAndSet(i,i+1)){

                    }
                    System.out.println("thread id" + Thread.currentThread().getName() + ",value: " + i);

                }
            }
        });

        service.execute(() -> {
            for (int i = 2; i <= 100; i++) {
                if (i % 2 == 0) {
                    while (!adder.compareAndSet(i,i+1)){

                    }
                    System.out.println("thread id" + Thread.currentThread().getName() + ",value: " + i);

                }
            }
        });

        System.out.println("main");
    }
}

class Adder implements Serializable {
    private static Field getUnsafe = null;
    private static Unsafe unsafe = null;

    private static final long valueOffset;
    private volatile int value;

    static {

        try {
            getUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            getUnsafe.setAccessible(true);
            unsafe = (Unsafe)getUnsafe.get(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            valueOffset = unsafe.objectFieldOffset(AtomicInteger.class.getDeclaredField("value"));
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }

    public Adder(int init) {
        value = init;
    }

    public void jumpAdd(int cur, int next) {

        do {
        } while (!unsafe.compareAndSwapInt(this, valueOffset, cur, next));

        System.out.println("thread id" + Thread.currentThread().getName() + ",value: " + cur);

    }
}