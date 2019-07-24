package com.tracy.nio;

import java.nio.ByteBuffer;

/**
 * 只读buffer<br/>
 *
 * 制度buffer,我们可以随时将一个普通buffer转为只读buffer，不能将只读buffer转为普通buffer。
 *
 * @author pengc
 * @version v3.1.0
 * @title NioTest7
 * @package com.tracy.nio
 * @time 2019/7/17 14:22
 */
public class NioTest7 {

    public static void main(String args[]) {

        ByteBuffer buffer = ByteBuffer.allocate(10);

        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte) i);
        }

        ByteBuffer readonlyBuffer = buffer.asReadOnlyBuffer();

        readonlyBuffer.put((byte)2);
    }

}
