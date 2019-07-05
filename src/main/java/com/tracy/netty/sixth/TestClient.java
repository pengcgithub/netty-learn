package com.tracy.netty.sixth;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * <br/>
 *
 * @author pengc
 * @version v3.0.0
 * @title TestServer
 * @package com.tracy.netty.sixth
 * @time 2019/5/18 16:50
 */
//public class TestClient {
//
//    public static void main(String args[]) throws Exception {
//        // 获取连接
//        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
//
//        try {
//            Bootstrap bootstrap = new Bootstrap();
//            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class).
//                    handler(new TestClientInitializer());
//
//            ChannelFuture channelFuture = bootstrap.connect("localhost", 8899).sync();
//            channelFuture.channel().closeFuture().sync();
//        } finally {
//            eventLoopGroup.shutdownGracefully();
//        }
//
//
//    }
//
//}
