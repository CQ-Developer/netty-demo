package io.huhu.netty.demo4;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel, AioServer> {

    @Override
    public void completed(AsynchronousSocketChannel result, AioServer attachment) {
        System.out.println("create connection: " + result);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        result.read(byteBuffer, byteBuffer, new ReadCompletionHandler());
    }

    @Override
    public void failed(Throwable exc, AioServer attachment) {

    }

}
