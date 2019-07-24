package com.tracy.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * <br/>
 * 存储在Java堆上，但是指向JVM之外的一块区域。
 *
 * @author pengc
 * @version v3.1.0
 * @title NioTest8
 * @package com.tracy.nio
 * @time 2019/7/17 14:33
 */
public class NioTest8 {

    public static void main(String args[]) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("input.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("output.txt");

        FileChannel inputChannel = fileInputStream.getChannel();
        FileChannel outputChannel = fileOutputStream.getChannel();

        // 涉及零拷贝的过程
        ByteBuffer buffer = ByteBuffer.allocateDirect(512);

        while (true) {
            buffer.clear();

            int read = inputChannel.read(buffer);

            System.out.println("read:" + read);

            if (-1 == read) {
                break;
            }

            buffer.flip();

            outputChannel.write(buffer);

        }

        inputChannel.close();
        outputChannel.close();
    }

}
