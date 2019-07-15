package com.mzzcy;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by changyin.zhao on 11/7/18
 */
public class TMain3 {

    public static void main(String[] args) {
//        int oldCapacity = Integer.MAX_VALUE - 16;
//        System.out.println(oldCapacity);
//        int minCapacity = Integer.MAX_VALUE - 15;
//        int maxSize = Integer.MAX_VALUE - 8;
//        int newCapacity = oldCapacity + (oldCapacity >> 1);
//
//        if (newCapacity - minCapacity < 0) {
//            newCapacity = minCapacity;
//        }
//        if (newCapacity - maxSize > 0) {
//            newCapacity = hugeCapacity(minCapacity);
//        }
//        // minCapacity is usually close to size, so this is a win:
//        System.out.println(newCapacity);

        Object[] a = {};
        Object[] b ={};
        System.out.println(a == b);
    }

}