package com.mzzcy.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author changyin.zhao on 6/13/19
 */
public class TimeClient {
    public static void main(String[] args) {
        int port = 9090;
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;

        try {

            socket = new Socket("127.0.0.1", port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println("order 1");
//            out.println("order 2");
//            System.out.println("Send order 2 server succeed");
//            String resp = in.readLine();
//            System.out.println("Now is: " + resp);
//
//            out.println("order 3");
//            System.out.println("Send order 2 server succeed");
//            resp = in.readLine();
//            resp = in.readLine();
//            System.out.println("Now is: " + resp);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
