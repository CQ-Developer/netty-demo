package io.huhu.netty.demo3;

import io.huhu.netty.demo3.operation.Operation;
import io.huhu.netty.demo3.operation.OperationResult;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderServerProcessHandler extends SimpleChannelInboundHandler<RequestMessage> {

    private final Logger log = LoggerFactory.getLogger(OrderServerProcessHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RequestMessage msg) throws Exception {
        Operation operation = msg.getMessageBody();
        OperationResult operationResult = operation.execute();

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessageHeader(msg.getMessageHeader());
        responseMessage.setMessageBody(operationResult);

        if (ctx.channel().isActive() && ctx.channel().isWritable()) {
            ctx.writeAndFlush(responseMessage);
        }
        else {
            log.error("not writable now, message dropped");
        }
    }

}
