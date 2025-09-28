package com.tigana.Utils;

import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "app") // to help retreive values from application.yml under app attribute
@Data
public class UserContext {

    private UUID UserId;

    // Prevent instantiation
    private UserContext() {
    }

    public static UUID getCurrentUserId() {
        return AppConstants.userId;
    }

}
