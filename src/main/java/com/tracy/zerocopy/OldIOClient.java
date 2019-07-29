package com.tracy.zerocopy;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.Socket;

/**
 * <br/>
 *
 * @author pengc
 * @version v3.1.0
 * @title OldIOClient
 * @package com.tracy.zerocopy
 * @time 2019/7/29 20:09
 */
public class OldIOClient {

    public static void main(String args[]) throws Exception {

        Socket socket = new Socket("localhost", 8899);

        String fileName = "";
        InputStream inputStream = new FileInputStream(fileName);

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        byte[] buffer = new byte[4096];
        long readCount;
        long total = 0;

        long startTime = System.currentTimeMillis();

        while ((readCount = inputStream.read(buffer)) >= 0) {
            total += readCount;
            dataOutputStream.write(buffer);
        }

        System.out.println("发送总字节：" + total + "，耗时：" + (System.currentTimeMillis() - startTime));

        dataOutputStream.close();
        socket.close();
        inputStream.close();

    }

}
