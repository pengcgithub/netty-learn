package com.tracy.netty.fourth;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * <br/>
 *
 * @author pengc
 * @see com.tracy.netty.third
 * @since 2019/5/9
 */
public class MyServer {

    public static void main(String args[]) throws Exception {
        // 获取连接
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // 接收连接
        EventLoopGroup workGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workGroup).channel(NioServerSocketChannel.class)
                    // 专门用于处理连接本身，处理bossGroup
                    .handler(new LoggingHandler(LogLevel.INFO))
                    // 处理用于处理workGroup
                    .childHandler(new MyServerInitializer());

            ChannelFuture channelFuture = serverBootstrap.bind(8899).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }


    }

}
