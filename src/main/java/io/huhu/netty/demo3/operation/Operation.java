package io.huhu.netty.demo3.operation;

import io.huhu.netty.demo3.message.MessageBody;

public abstract class Operation extends MessageBody {

    public abstract OperationResult execute();

}
