package com.tracy.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Set;

/**
 * <br/>
 *
 * @author pengc
 * @version v3.1.0
 * @title NioServer
 * @package com.tracy.nio
 * @time 2019/7/24 17:42
 */
public class NioServer {

    public static void main(String args[]) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 配置非诸塞
        serverSocketChannel.configureBlocking(false);
        // 获取服务器端的socket对象
        ServerSocket serverSocket = serverSocketChannel.socket();
        // 绑定到8899端口号
        serverSocket.bind(new InetSocketAddress(8899));

        Selector selector = Selector.open();
        // 事件，将channel对象分别注册到selector选择器上
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        // 事件处理
        while (true) {
            try {
                // 阻塞，一直等到有客户端注册，就会有返回值
                selector.select();

                // 返回所有注册的对象
                Set<SelectionKey> selectionKeys = selector.selectedKeys();

                // 遍历集合
                selectionKeys.forEach(selectionKey -> {
                    try {
                        if (selectionKey.isAcceptable()) {
                            ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();

                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });


            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

}
