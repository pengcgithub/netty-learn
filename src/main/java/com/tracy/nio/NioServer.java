package com.tracy.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

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

    private static Map<String, SocketChannel> clientMap = new HashMap<>();

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
                    final SocketChannel client;

                    try {
                        if (selectionKey.isAcceptable()) {
                            ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
                            client = server.accept();
                            client.configureBlocking(false);
                            client.register(selector, SelectionKey.OP_READ);

                            String key = "[" + UUID.randomUUID().toString() + "]";

                            clientMap.put(key, client);

                        } else if (selectionKey.isReadable()) {
                            client = (SocketChannel) selectionKey.channel();

                            ByteBuffer readBuffer = ByteBuffer.allocate(1024);

                            int count = client.read(readBuffer);

                            if (count > 0) {
                                readBuffer.flip();

                                Charset charset = Charset.forName("utf-8");
                                String receiveMessage = String.valueOf(charset.decode(readBuffer).array());

                                System.out.println(client + " : " + receiveMessage);

                                String senderKey = null;

                                for (Map.Entry<String, SocketChannel> entry : clientMap.entrySet()) {
                                    if (client == entry.getValue()) {
                                        senderKey = entry.getKey();
                                        break;
                                    }
                                }

                                for (Map.Entry<String, SocketChannel> entry : clientMap.entrySet()) {
                                    SocketChannel value = entry.getValue();

                                    ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
                                    writeBuffer.put((senderKey + ":" + receiveMessage).getBytes());
                                    writeBuffer.flip();

                                    value.write(writeBuffer);
                                }

                            }

                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

                selectionKeys.clear();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

}
