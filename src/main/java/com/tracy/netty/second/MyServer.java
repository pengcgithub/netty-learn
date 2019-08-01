package com.tracy.netty.second;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * <br/>
 *
 * @author pengc
 * @version v3.1.0
 * @title MyServer
 * @package com.tracy.netty.second
 * @time 2019/7/29 21:01
 */
public class MyServer {

    public static void main(String args[]) {

        // 仅仅用于接收转发的作用
        EventLoopGroup bossGroup = new NioEventLoopGroup();

        // 完成处理的逻辑
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new MyServerInitializer());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
