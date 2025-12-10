package com.tigana.Utils;

import java.util.Optional;
import java.util.UUID;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.google.firebase.auth.FirebaseToken;

import lombok.experimental.UtilityClass;

@UtilityClass
public class AuthenticationUtils {

    public static FirebaseToken getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof FirebaseToken) {
            return (FirebaseToken) auth.getPrincipal();
        }
        throw new IllegalStateException("No authenticated user found or wrong principal type");
    }

    public static String getCurrentUserId() {
        FirebaseToken currentUser = getCurrentUser();
        return currentUser.getUid();
    }

    public static Optional<String> getOptionalSchoolId() {
        FirebaseToken currentUser = getCurrentUser();
        return Optional.ofNullable(currentUser.getClaims().get("schoolId").toString());
    }

    public static UUID getSchoolId() {
        FirebaseToken currentUser = getCurrentUser();
        Optional<Object> optionalSchoolId = Optional.ofNullable(currentUser.getClaims().get("schoolId"));
        if (optionalSchoolId.isEmpty())
            throw new IllegalStateException("No schoolId found for the current user");
        if (!(optionalSchoolId.get() instanceof String))
            throw new IllegalStateException("schoolId found in user claims is not a valid UUID string");
        return UUID.fromString(optionalSchoolId.get().toString());
    }

}
