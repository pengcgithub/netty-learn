package com.tracy.grpc;

import com.tracy.proto.StudentRequest;
import com.tracy.proto.StudentResponse;
import com.tracy.proto.StudentServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * <br/>
 *
 * @author pengc
 * @see com.tracy.grpc
 * @since 2019/7/5
 */
public class GrpcClient {

    public static void main(String[] args) throws Exception {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8899)
                .usePlaintext()
                .build();

        StudentServiceGrpc.StudentServiceBlockingStub blockingStub = StudentServiceGrpc.newBlockingStub(managedChannel);
        StudentRequest request = StudentRequest.newBuilder().setName("张三").build();
        StudentResponse response = blockingStub.getStudentName(request);

        System.out.println("返回请求参数>>"+response.getMessage());

        managedChannel.shutdown();
    }

}
