package com.tigana.Utils;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.google.firebase.auth.FirebaseToken;
import com.tigana.Firebase.Service.FirebaseAuthService;
import com.tigana.Interfaces.CurrentUser;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CurrentUserArgumentResolver implements HandlerMethodArgumentResolver {

    private final FirebaseAuthService firebaseAuthService;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(CurrentUser.class)
                && parameter.getParameterType().equals(FirebaseToken.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
            ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory) throws Exception {

        return UserContext.getCurrentUserDetails();

        // HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        // String authHeader = request.getHeader("Authorization");

        // if (authHeader == null || !authHeader.startsWith("Bearer ")) {
        //     throw new RuntimeException("Missing Authorization header");
        // }
        // String idToken = authHeader.substring(7);
        // // Verify the token
        // return firebaseAuthService.verifyIdToken(idToken);
    }

}
