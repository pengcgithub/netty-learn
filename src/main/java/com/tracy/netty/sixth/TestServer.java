package com.tracy.netty.sixth;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import java.net.InetSocketAddress;

/**
 * <br/>
 *
 * @author pengc
 * @version v3.0.0
 * @title TestServer
 * @package com.tracy.netty.sixth
 * @time 2019/5/18 16:50
 */
//public class TestServer {
//
//    public static void main(String args[]) throws Exception {
//        // 获取连接
//        EventLoopGroup bossGroup = new NioEventLoopGroup();
//        // 接收连接
//        EventLoopGroup workGroup = new NioEventLoopGroup();
//
//        try {
//            ServerBootstrap serverBootstrap = new ServerBootstrap();
//            serverBootstrap.group(bossGroup, workGroup).channel(NioServerSocketChannel.class)
//                    .handler(new LoggingHandler(LogLevel.INFO))
//                    .childHandler(new TestInitializer());
//
//            ChannelFuture channelFuture = serverBootstrap.bind(new InetSocketAddress(8899)).sync();
//            channelFuture.channel().closeFuture().sync();
//        } finally {
//            bossGroup.shutdownGracefully();
//            workGroup.shutdownGracefully();
//        }
//
//
//    }
//
//}
