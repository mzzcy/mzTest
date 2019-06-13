package com.mzzcy.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer2 {

  public static void main(String[] args) throws IOException {
    int port = 9090;

    ServerSocket server = null;

    try {
      server = new ServerSocket(port);
      Socket socket = null;
      TimeServerHandlerExecutePool executePool = new TimeServerHandlerExecutePool(50, 10000);

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
