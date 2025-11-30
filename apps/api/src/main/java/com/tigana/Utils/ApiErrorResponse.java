package com.tigana.Utils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class ApiErrorResponse {

    protected final boolean success = false;

    protected String message;

    protected final LocalDateTime timestamp = LocalDateTime.now();

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected List<String> errors;

    protected String path;

    protected Map<String, Object> metadata;

    protected HttpStatus status;

}
