package com.tigana.Utils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    @NotBlank
    protected String message;

    @NotNull
    @NotBlank
    protected final LocalDateTime timestamp = LocalDateTime.now();

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected List<String> errors;

    @NotNull
    @NotBlank
    protected String path;

    protected Map<String, Object> metadata;

    @NotBlank
    @NotNull
    protected HttpStatus status;

}
