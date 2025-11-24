package com.tigana.Users.DTO;

import com.tigana.Enums.RoleEnums;

public record UserResponse(String id, String email, String username, RoleEnums role, String schoolId) {

}
