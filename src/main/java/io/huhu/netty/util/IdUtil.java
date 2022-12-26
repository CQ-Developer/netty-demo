package io.huhu.netty.util;

import java.util.concurrent.atomic.AtomicLong;

public final class IdUtil {

    private static final AtomicLong IDX = new AtomicLong();

    private IdUtil() {
        throw new IllegalAccessError("not allowed instantiation!");
    }

    public static long nextId() {
        return IDX.incrementAndGet();
    }

}
