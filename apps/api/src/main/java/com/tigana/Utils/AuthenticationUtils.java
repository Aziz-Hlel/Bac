package com.tigana.Utils;

import java.util.Optional;

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

        if (currentUser != null)
            return currentUser.getUid();
        throw new IllegalStateException("No authenticated user found");
    }

}
