package com.tracy.zerocopy;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;

/**
 * <br/>
 *
 * @author pengc
 * @version v3.1.0
 * @title OldServer
 * @package com.tracy.zerocopy
 * @time 2019/7/29 19:07
 */
public class OldServer {

    public static void main(String args[]) throws Exception {

        ServerSocket serverSocket = new ServerSocket(8899);

        while (true) {
            // 阻塞的方法，直到有连接建立才会有数据返回。
            Socket socket = serverSocket.accept();

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            try {
                // 缓冲区
                byte[] byteArray = new byte[4096];

                //获取对端传递过来的数据
                while (true) {
                    int readCount = dataInputStream.read(byteArray, 0, byteArray.length);

                    if (readCount == -1) {
                        break;
                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

}
