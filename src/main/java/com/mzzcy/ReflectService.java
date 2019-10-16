package com.mzzcy;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author changyin.zhao on 10/16/19
 */
public class ReflectService {
    public void sayHello(String name) {
        System.out.println("hello " + name);
    }

    public static void main(String[] args) throws Exception {
        ArrayList<String> sA = new ArrayList<>();
        ArrayList<?> sB = new ArrayList<>();
        Object b = sB.get(0);
        ArrayList<?>  xA = new ArrayList<String>();
        xA = sA;
    }
}
