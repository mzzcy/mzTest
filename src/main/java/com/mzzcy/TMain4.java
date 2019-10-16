package com.mzzcy;

import java.util.ArrayList;

class ClassA {
    static {
        System.out.println("now init ClassA");
    }
}

public class TMain4 {
    public static void main(String[] args) throws Exception {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class objClass = loader.loadClass("com.mzzcy.ClassA");
        System.out.println("after load ClassA");
        System.out.println("before init ClassA");
//        objClass = Class.forName("com.mzzcy.ClassA");
        objClass.newInstance();

        ArrayList<?> arr2 = new ArrayList<>();
        arr2 = new ArrayList<String>();
        arr2 = new ArrayList<Integer>();
    }
}
