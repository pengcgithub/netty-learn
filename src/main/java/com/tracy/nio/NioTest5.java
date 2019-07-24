package com.tracy.nio;

import java.nio.ByteBuffer;

/**
 * ByteBuffer类型化put与get
 */
public class NioTest5 {

    public static void main(String args[]) {
        ByteBuffer buffer = ByteBuffer.allocate(64);

        buffer.putInt(10);
        buffer.putLong(5000000000L);
        buffer.putChar('你');

        buffer.flip();

        System.out.println(buffer.getInt());
        System.out.println(buffer.getLong());
        System.out.println(buffer.getChar());
    }

}
