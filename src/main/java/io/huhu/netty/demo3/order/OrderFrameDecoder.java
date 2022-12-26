package io.huhu.netty.demo3.order;

import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

import static java.lang.Integer.MAX_VALUE;

public class OrderFrameDecoder extends LengthFieldBasedFrameDecoder {

    public OrderFrameDecoder() {
        super(MAX_VALUE, 0, 2, 0, 2);
    }

}
