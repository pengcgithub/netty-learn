package com.tracy.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

/**
 * <br/>
 *
 * @author pengc
 * @see com.tracy.grpc
 * @since 2019/7/5
 */
public class GrpcService {

    private Server server;

    private void start() throws IOException {
        /* The port on which the server should run */
        int port = 8899;
        server = ServerBuilder.forPort(port)
                .addService(new StudentServiceImpl())
                .build()
                .start();

        // 钩子函数
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                GrpcService.this.stop();
                System.err.println("*** server shut down");
            }
        });

        System.out.println("测试钩子函数是否为异步");
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final GrpcService server = new GrpcService();
        server.start();
        server.blockUntilShutdown();
    }

}
