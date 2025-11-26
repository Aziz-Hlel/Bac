package com.tigana.Utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.firebase.auth.FirebaseToken;
import com.tigana.Firebase.Service.FirebaseAuthService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Aspect
@Component
@RequiredArgsConstructor
public class RequireAuthAspect {

    private final FirebaseAuthService firebaseAuthService;

    @Around("@annotation(com.tigana.Interfaces.RequireAuth)")
    public Object authenticate(ProceedingJoinPoint joinPoint) throws Throwable {

        // Get the current HTTP request
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes())
                .getRequest();

        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new RuntimeException("Missing Authorization header");
        }
        String idToken = authHeader.substring(7);

        FirebaseToken token = firebaseAuthService.verifyIdToken(idToken);

        // Optionally store token in request attributes for controller access
        request.setAttribute("firebaseToken", token);

        // Proceed to controller
        return joinPoint.proceed();
    }

}
