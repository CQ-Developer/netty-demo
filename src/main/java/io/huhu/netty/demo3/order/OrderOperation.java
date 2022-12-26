package io.huhu.netty.demo3.order;

import io.huhu.netty.demo3.operation.Operation;
import io.huhu.netty.demo3.operation.OperationResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderOperation extends Operation {

    private final Logger log = LoggerFactory.getLogger(OrderOperation.class);

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
        log.info("order's executing startup with orderRequest: {}", this);
        // 等待3秒, 模拟IO型业务
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("order's executing complete");
        return new OrderOperationResult(tableId, dish, true);
    }

}
