package com.tracy.netty.first;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * <br/>
 *
 * @author pengc
 * @version v3.0.0
 * @title TestServerInitializer
 * @package com.tracy.netty.first
 * @time 2019/5/7 17:53
 */
public class TestServerInitializer extends ChannelInitializer<SocketChannel> {

    /**
     * 相当于时回调的方法
     */

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast("httpServerCodec", new HttpServerCodec());
        pipeline.addLast("testHttpServerHandler", new TestHttpServerHandler());


    }
}
