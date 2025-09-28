package com.tigana.Auth.DTO;

import lombok.Data;

@Data
public class RefreshResponse {

    private String accessToken;
    private String refreshToken;
}
