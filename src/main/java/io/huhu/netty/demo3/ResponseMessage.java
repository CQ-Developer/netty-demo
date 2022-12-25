package io.huhu.netty.demo3;

import io.huhu.netty.demo3.message.Message;
import io.huhu.netty.demo3.operation.OperationResult;
import io.huhu.netty.demo3.operation.OperationType;

public class ResponseMessage extends Message<OperationResult> {

    @Override
    public Class getMessageBodyDecodeClass(int opcode) {
        return OperationType.fromOpCode(opcode).getOperationResultType();
    }

}
