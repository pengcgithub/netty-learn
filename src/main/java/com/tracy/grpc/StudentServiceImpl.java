package com.tracy.grpc;

import com.tracy.proto.StudentRequest;
import com.tracy.proto.StudentResponse;
import com.tracy.proto.StudentServiceGrpc;
import io.grpc.stub.StreamObserver;

/**
 * <br/>
 *
 * @author pengc
 * @see com.tracy.grpc
 * @since 2019/7/5
 */
public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase {

    @Override
    public void getStudentName(StudentRequest request, StreamObserver<StudentResponse> responseObserver) {
        System.out.println("请求参数>>"+request.getName());

        responseObserver.onNext(StudentResponse.newBuilder().setMessage("请求成功啦").build());
        responseObserver.onCompleted();
    }
}
