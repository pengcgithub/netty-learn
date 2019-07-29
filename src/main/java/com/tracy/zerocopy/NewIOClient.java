package com.tracy.zerocopy;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * <br/>
 *
 * @author pengc
 * @version v3.1.0
 * @title NewIOClient
 * @package com.tracy.zerocopy
 * @time 2019/7/29 20:18
 */
public class NewIOClient {

    public static void main(String args[]) throws Exception {

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(true);
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 8899));

        String fileName = "";
        FileChannel fileChannel = new FileInputStream(fileName).getChannel();

        long startTime = System.currentTimeMillis();

        // transferTo 借助零拷贝的方式
        long transferCount = fileChannel.transferTo(0, fileChannel.size(), socketChannel);

        System.out.println("发送总字节：" + transferCount + "，耗时：" + (System.currentTimeMillis() - startTime));

        fileChannel.close();

    }

}
