package com.tigana.Users.Controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tigana.Enums.RoleEnums;
import com.tigana.Users.DTO.UserResponse;
import com.tigana.Users.Service.UserService;
import com.tigana.shared.Dto.CustomPage;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping({ "", "/" })
    public CustomPage<UserResponse> users(@RequestParam(required = false) String search,
            @RequestParam(required = false) RoleEnums role,
            @PageableDefault(size = 5, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
        return userService.searchUsers(search, role, pageable);
    }

}
