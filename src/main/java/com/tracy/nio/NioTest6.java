package com.tracy.nio;

import java.nio.ByteBuffer;

/**
 * 分片Buffer<br/>
 *
 * slice buffer 与原有的buffer共享底层的数组
 *
 * @author pengc
 * @version v3.1.0
 * @title NioTest6
 * @package com.tracy.nio
 * @time 2019/7/17 11:58
 */
public class NioTest6 {

    public static void main(String args[]) {

        ByteBuffer buffer = ByteBuffer.allocate(10);

        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte) i);
        }

        buffer.position(2);
        buffer.limit(6);
        ByteBuffer sliceBuffer = buffer.slice();

        for (int i = 0; i < sliceBuffer.capacity(); i++) {
            byte b = sliceBuffer.get(i);
            b *= 2;

            sliceBuffer.put(i, b);
        }

        buffer.position(0);
        buffer.limit(buffer.capacity());

        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }

    }

}
