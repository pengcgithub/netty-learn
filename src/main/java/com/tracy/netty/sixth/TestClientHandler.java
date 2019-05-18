package com.tracy.netty.sixth;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * <br/>
 *
 * @author pengc
 * @version v3.0.0
 * @title TestServerHandler
 * @package com.tracy.netty.sixth
 * @time 2019/5/18 16:55
 */
public class TestClientHandler extends SimpleChannelInboundHandler<DataInfo.Person> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.Person msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        DataInfo.Person person = DataInfo.Person.newBuilder()
                .setName("张三").setAge(20).setAddress("北京").build();

        ctx.channel().writeAndFlush(person);
    }
}
