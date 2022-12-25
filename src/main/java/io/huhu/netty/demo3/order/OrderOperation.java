package io.huhu.netty.demo3.order;

import io.huhu.netty.demo3.operation.Operation;
import io.huhu.netty.demo3.operation.OperationResult;

public class OrderOperation extends Operation {

    private int tableId;

    private String dish;

    public OrderOperation(int tableId, String dish) {
        this.tableId = tableId;
        this.dish = dish;
    }

    public int getTableId() {
        return tableId;
    }

    public String getDish() {
        return dish;
    }

    @Override
    public OperationResult execute() {
        return null;
    }

}
