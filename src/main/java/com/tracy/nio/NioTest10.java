package com.tracy.nio;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * 文件锁的概念<br/>
 *
 * @author pengc
 * @version v3.1.0
 * @title NioTest10
 * @package com.tracy.nio
 * @time 2019/7/18 15:44
 */
public class NioTest10 {

    public static void main(String args[]) throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile("NioTest9.txt", "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();

        FileLock fileLock = fileChannel.lock(3, 6, true);

        System.out.println(fileLock.isValid());
        System.out.println(fileLock.isShared());

        fileLock.release();

        randomAccessFile.close();

    }

}
