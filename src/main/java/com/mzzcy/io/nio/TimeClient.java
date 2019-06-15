package com.mzzcy.io.nio;

/**
 * @author changyin.zhao on 6/15/19
 */
public class TimeClient {
    public static void main(String args[]) {
        int port = 9090;

        new Thread(new TimeClientHandle("127.0.0.1", port), "TimeClient-001").start();
    }
}
