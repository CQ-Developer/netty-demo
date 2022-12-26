package io.huhu.netty.demo4;

import java.nio.ByteBuffer;
import java.nio.channels.CompletionHandler;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ReadCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {

    @Override
    public void completed(Integer result, ByteBuffer attachment) {
        attachment.flip();
        byte[] body = new byte[result];
        attachment.get(body);
        String requestMessage = new String(body, UTF_8);
        System.out.println(requestMessage);
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {

    }
}
