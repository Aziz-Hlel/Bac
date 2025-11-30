package com.tigana.Interfaces;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

/**
 * Custom annotation to inject the currently authenticated Firebase user into
 * controller methods.
 * 
 * This annotation is a meta-annotation that wraps Spring
 * Security's @AuthenticationPrincipal,
 * making it easier to inject FirebaseToken objects without boilerplate code.
 * 
 * Usage:
 * 
 * <pre>
 * {@code
 * @GetMapping("/profile")
 * public ResponseEntity<UserDto> getProfile(@CurrentUser FirebaseToken token) {
 *     String userId = token.getUid();
 *     String email = token.getEmail();
 *     return ResponseEntity.ok(userService.getProfile(userId));
 * }
 * }
 * </pre>
 * 
 * This is equivalent to:
 * 
 * <pre>
 * {@code
 * public ResponseEntity<UserDto> getProfile(
 *     &#64;AuthenticationPrincipal FirebaseToken token
 * ) { ... }
 * }
 * </pre>
 * 
 * @see org.springframework.security.core.annotation.AuthenticationPrincipal
 */

@Target({ ElementType.PARAMETER, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@AuthenticationPrincipal
public @interface CurrentUser {
}
