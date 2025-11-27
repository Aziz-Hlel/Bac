package com.tigana.Utils;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.apache.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
public class ApiSuccessResponse<T> {

    protected final boolean success = true;

    @NonNull
    protected String message;

    @NonNull
    protected T data;

    @NonNull
    protected final LocalDateTime timestamp = LocalDateTime.now();

    protected String path;

    @NonNull
    protected HttpStatus status;

    protected Map<String, Object> metadata;

}
