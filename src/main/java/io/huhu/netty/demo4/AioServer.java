package io.huhu.netty.demo4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;

public class AioServer {

    public AsynchronousServerSocketChannel serverSocketChannel;

    public AioServer(int port) {
        try {
            serverSocketChannel = AsynchronousServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(port));
            serverSocketChannel.accept(this, new AcceptHandler());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
