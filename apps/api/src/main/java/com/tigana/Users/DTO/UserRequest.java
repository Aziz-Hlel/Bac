package com.tigana.Users.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor
public class UserRequest {

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
    private String tokenId;

}