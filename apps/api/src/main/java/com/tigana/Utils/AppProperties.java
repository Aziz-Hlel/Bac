package com.tigana.Utils;

import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "app") // to help retreive values from application.yml under app attribute
@Data
@Validated
public class AppProperties {

    // @NotBlank    
    private UUID UserId;

    @NotBlank
    private String firebaseServiceAccount;

}
