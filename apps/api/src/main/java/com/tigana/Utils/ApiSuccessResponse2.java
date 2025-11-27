package com.tigana.Utils;

import java.time.Instant;
import java.util.Map;

public record ApiSuccessResponse2<T>(
        boolean success,
        String message,
        T data,
        String timestamp,
        int status,
        String path,
        Map<String, Object> metadata

) {
    public ApiSuccessResponse2 {
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("message cannot be null or blank");
        }
        if (data == null) {
            throw new IllegalArgumentException("data cannot be null");
        }
        if (timestamp == null) {
            throw new IllegalArgumentException("timestamp cannot be null");
        }
        if (status <= 0) {
            throw new IllegalArgumentException("status must be > 0");
        }
        // path and metadata can remain nullable if intended
    }

    public ApiSuccessResponse2(String message, T data, int status, String path, Map<String, Object> metadata) {
        this(true, message, data, Instant.now().toString(), status, path, metadata);
    }
}
