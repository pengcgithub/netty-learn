package com.tracy.nio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.RandomAccess;

/**
 * <br/>
 *
 * @author pengc
 * @version v3.1.0
 * @title NioTest9
 * @package com.tracy.nio
 * @time 2019/7/18 15:37
 */
public class NioTest9 {

    public static void main(String args[]) throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile("NioTest9.txt", "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();

        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 5);

        mappedByteBuffer.put(0, (byte)'a');

        randomAccessFile.close();
    }

}
