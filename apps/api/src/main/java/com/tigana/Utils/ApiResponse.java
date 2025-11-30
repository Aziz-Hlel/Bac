package com.tigana.Utils;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {

    protected final boolean success = true;

    protected String message;

    protected T data;

    protected final LocalDateTime timestamp = LocalDateTime.now();

    protected String path;

    protected HttpStatus status;

    @JsonInclude(JsonInclude.Include.NON_EMPTY) // Forgetting null safety: Not using @JsonInclude properly, sending
                                                // unnecessary null fields
    protected Map<String, Object> metadata;

}