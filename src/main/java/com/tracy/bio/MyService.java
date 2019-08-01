package com.tracy.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <br/>
 *
 * @author pengc
 * @version v3.1.0
 * @title MyService
 * @package com.tracy.bio
 * @time 2019/8/1 17:34
 */
public class MyService {

    public static void main(String args[]) throws Exception {

        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress("127.0.0.1", 8899));

        while (true) {
            Socket socket = serverSocket.accept();

            new Thread(() -> {
                try {
                    byte[] bytes = new byte[1024];
                    int readLen = socket.getInputStream().read(bytes, 0, bytes.length);
                    socket.getOutputStream().write(bytes, 0, readLen);
                    socket.getOutputStream().flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

        }

    }

}
