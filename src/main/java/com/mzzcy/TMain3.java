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
    for (int i = 0; i < 12; i++) {
      if (i % 2 == 1) {
        continue;
      }
System.out.println(i);
    }
  }
}