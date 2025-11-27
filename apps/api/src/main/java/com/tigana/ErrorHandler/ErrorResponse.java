package com.tigana.ErrorHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;

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
public class ErrorResponse {

    protected final boolean success = false;

    @NotNull
    @NotBlank
    protected String message;

    @NotNull
    @NotBlank
    protected final LocalDateTime timestamp = LocalDateTime.now();

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> errors;

    @NotNull
    @NotBlank
    protected String path;

    @NotBlank
    @NotNull
    protected HttpStatus status;

}
