package com.tigana.Utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;

import com.google.firebase.auth.FirebaseToken;

import lombok.Data;

@Data
public class UserContext {

    private UserContext() {} // utility class, cannot inject beans here

    public static FirebaseToken getCurrentUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof FirebaseToken token) {
            return token;
        }
        throw new IllegalStateException("No authenticated user found or wrong principal type");
    }

    public static String getCurrentUserId() {
        return getCurrentUserDetails().getUid();
    }
}
