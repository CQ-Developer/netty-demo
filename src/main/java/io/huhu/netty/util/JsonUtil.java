package io.huhu.netty.util;

import com.google.gson.Gson;

public final class JsonUtil {

    private static final Gson GSON = new Gson();

    private JsonUtil() {
        throw new IllegalAccessError("not allowed instantiation!");
    }

    public static <T> T fromJson(String json, Class<T> type) {
        return GSON.fromJson(json, type);
    }

    public static String toJson(Object object) {
        return GSON.toJson(object);
    }

}
