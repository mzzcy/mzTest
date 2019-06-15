package com.mzzcy.io.nio;

import java.io.IOException;

/**
 * @author changyin.zhao on 6/15/19
 */
public class NIOTimerServer {

    public static void main(String[] args) throws IOException {
        int port = 8080;
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
    }
}
