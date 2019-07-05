package com.tracy.netty.sixth;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

/**
 * <br/>
 *
 * @author pengc
 * @version v3.0.0
 * @title TestClientInitializer
 * @package com.tracy.netty.sixth
 * @time 2019/5/18 17:02
 */
//public class TestClientInitializer extends ChannelInitializer<SocketChannel> {
//
//    @Override
//    protected void initChannel(SocketChannel ch) throws Exception {
//        ChannelPipeline pipeline = ch.pipeline();
//
//        pipeline.addLast(new ProtobufVarint32FrameDecoder());
//        pipeline.addLast(new ProtobufDecoder(DataInfo.MyMessage.getDefaultInstance()));
//        pipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
//        pipeline.addLast(new ProtobufEncoder());
//
//        pipeline.addLast(new TestClientHandler());
//    }
//
//}
