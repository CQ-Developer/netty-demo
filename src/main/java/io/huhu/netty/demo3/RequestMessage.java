package io.huhu.netty.demo3;

import io.huhu.netty.demo3.message.Message;
import io.huhu.netty.demo3.message.MessageHeader;
import io.huhu.netty.demo3.operation.Operation;
import io.huhu.netty.demo3.operation.OperationType;

public class RequestMessage extends Message<Operation> {

    public RequestMessage() {}

    public RequestMessage(Long streamId, Operation operation) {
        MessageHeader messageHeader = new MessageHeader();
        messageHeader.setStreamId(streamId);
        messageHeader.setOpCode(OperationType.fromOperation(operation).getOpCode());
        this.setMessageHeader(messageHeader);
        this.setMessageBody(operation);
    }

    @Override
    public Class getMessageBodyDecodeClass(int opcode) {
        return OperationType.fromOpCode(opcode).getOperationType();
    }

}
