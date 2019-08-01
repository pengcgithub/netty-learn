package com.tracy.bio;

import java.net.Socket;

/**
 * <br/>
 *
 * @author pengc
 * @version v3.1.0
 * @title MyClient
 * @package com.tracy.bio
 * @time 2019/8/1 17:42
 */
public class MyClient {

    public static void main(String args[]) throws Exception {

        Socket socket = new Socket("127.0.0.1", 8899);

        socket.getOutputStream().write("测试下BIO".getBytes());
        socket.getOutputStream().flush();

        byte[] bytes = new byte[1024];
        int readLen = socket.getInputStream().read(bytes);
        System.out.println(new String(bytes, 0, readLen));
        socket.close();

    }

}
