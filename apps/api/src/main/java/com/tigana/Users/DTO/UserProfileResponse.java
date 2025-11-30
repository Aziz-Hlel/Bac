package com.tigana.Users.DTO;

import com.tigana.Enums.RoleEnums;

public record UserProfileResponse(String id, String email, String username, RoleEnums role, String schoolId,
        String avatar) {

}
