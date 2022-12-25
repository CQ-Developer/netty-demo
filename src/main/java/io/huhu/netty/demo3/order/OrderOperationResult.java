package io.huhu.netty.demo3.order;

import io.huhu.netty.demo3.operation.OperationResult;

public class OrderOperationResult extends OperationResult {

    private final int tableId;

    private final String dish;

    private final boolean complete;

    public OrderOperationResult(int tableId, String dish, boolean complete) {
        this.tableId = tableId;
        this.dish = dish;
        this.complete = complete;
    }

    public int getTableId() {
        return tableId;
    }

    public String getDish() {
        return dish;
    }

    public boolean isComplete() {
        return complete;
    }

}
