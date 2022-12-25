package io.huhu.netty.demo3.operation;

import io.huhu.netty.demo3.auth.AuthOperation;
import io.huhu.netty.demo3.auth.AuthOperationResult;
import io.huhu.netty.demo3.keepalive.KeepAliveOperation;
import io.huhu.netty.demo3.keepalive.KeepAliveOperationResult;
import io.huhu.netty.demo3.order.OrderOperation;
import io.huhu.netty.demo3.order.OrderOperationResult;

import java.util.function.Predicate;

public enum OperationType {

    AUTH(1, AuthOperation.class, AuthOperationResult.class),
    KEEP_ALIVE(2, KeepAliveOperation.class, KeepAliveOperationResult.class),
    ORDER(3, OrderOperation.class, OrderOperationResult.class);

    final int opCode;

    final Class<? extends Operation> operation;

    final Class<? extends OperationResult> operationResult;

    OperationType(int opCode, Class<? extends Operation> operation, Class<? extends OperationResult> operationResult) {
        this.opCode = opCode;
        this.operation = operation;
        this.operationResult = operationResult;
    }

    public static OperationType fromOpCode(int type) {
        return getOperationType(requestType -> requestType.opCode == type);
    }

    public static OperationType fromOperation(Operation operation) {
        return getOperationType(requestType -> requestType.operation == operation.getClass());
    }

    private static OperationType getOperationType(Predicate<OperationType> predicate) {
        OperationType[] values = values();
        for (OperationType operationType : values) {
            if (predicate.test(operationType)) {
                return operationType;
            }
        }

        throw new AssertionError("no found type");
    }

    public int getOpCode() {
        return opCode;
    }

    public Class<? extends Operation> getOperationType() {
        return operation;
    }

    public Class<? extends OperationResult> getOperationResultType() {
        return operationResult;
    }

}
