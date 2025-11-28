package com.tigana.Users.DTO;

import com.tigana.Enums.RoleEnums;
import com.tigana.Users.Enums.SortEnums;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPageRequest {

    private int page = 1;

    private int limit = 5;

    @Nullable
    private SortEnums sort = SortEnums.DESC;

    @Nullable
    private String search;

    @Nullable
    private RoleEnums role;

}
