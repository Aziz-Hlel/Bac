package com.tigana.Users.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.google.firebase.auth.FirebaseToken;
import com.tigana.Users.DTO.UserProfileResponse;
import com.tigana.Users.DTO.UserResponse;
import com.tigana.Users.Model.User;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserMapper {

    @Mapping(target = "schoolId", source = "user.school.id")
    @Mapping(target = "avatar", source = "firebaseToken.picture")
    @Mapping(target = "email", source = "user.email")
    UserProfileResponse toUserProfile(User user, FirebaseToken firebaseToken);

    @Mapping(target = "schoolId", source = "user.school.id")
    UserResponse toDto(User user);
}
