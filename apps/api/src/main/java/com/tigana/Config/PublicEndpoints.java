package com.tigana.Config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PublicEndpoints {

    // Centralized public endpoints (no authentication required)
    private static final String[] PUBLIC_ENDPOINTS = {
            "/auth/**",
            "/public/**",
            "/health",
            "/health/",
            "/actuator/health", // For production health checks
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/v3/api-docs.yaml",
            "/v3/api-docs" // Without trailing slash
    };

    @Value("${server.servlet.context-path:}")
    private String contextPath;

    public String[] getPublicEndpointsWithContext() {
        if (contextPath == null || contextPath.isEmpty() || contextPath.equals("/")) {
            return PUBLIC_ENDPOINTS;
        }

        return Arrays.stream(PUBLIC_ENDPOINTS)
                .map(endpoint -> contextPath + endpoint)
                .toArray(String[]::new);
    }
}