package com.mzzcy;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by changyin.zhao on 11/2/18
 */
public class TMain {

    static int index = 0;

    public static void main(String[] args) throws IOException {

        ExecutorService service = Executors.newCachedThreadPool();

        Count count = new Count();
        // 100个线程对共享变量进行加1
        for (int i = 0; i < 300; i++) {
            service.execute(() -> count.increase());
        }

        // 等待上述的线程执行完
        service.shutdown();
        try {
            service.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count.getCount());

    }

    static class Count {

        // 共享变量
        private Integer count = 0;

        public Integer getCount() {
            return count;
        }

        public void increase() {
            count++;
        }
    }

}
