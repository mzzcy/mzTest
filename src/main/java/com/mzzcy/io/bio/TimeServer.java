package com.mzzcy.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author changyin.zhao on 6/13/19
 */
public class TimeServer {

    public static void main(String[] args) throws IOException {
        int port = 9090;

        ServerSocket server = null;

        try {
            server = new ServerSocket(port);
            Socket socket = null;
            while (true) {
                socket = server.accept();
                new Thread(new TimeServerHandler(socket)).start();

            }
        } finally {
            if (server != null) {
                System.out.println("server close");
                server.close();
            }
        }

    }
}
