package com.tigana.Users.Service;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.google.firebase.auth.FirebaseToken;
import com.tigana.Enums.RoleEnums;
import com.tigana.ErrorHandler.Exceptions.ResourceNotFoundException;
import com.tigana.Firebase.Service.FirebaseAuthService;
import com.tigana.School.Model.School;
import com.tigana.SchoolClasses.DTO.SchoolClassesResponse;
import com.tigana.SchoolClasses.Service.SchoolClassesService;
import com.tigana.Users.DTO.UserProfileResponse;
import com.tigana.Users.DTO.onboardingResponse;
import com.tigana.Users.Mapper.UserMapper;
import com.tigana.Users.Model.User;
import com.tigana.Users.Repositry.UsersRepo;
import com.tigana.Utils.AuthenticationUtils;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class AuthService {

    private final UsersRepo usersRepo;
    private final UserMapper userMapper;
    private final FirebaseAuthService firebaseService;
    private final SchoolClassesService schoolClassesService;

    private final Logger logger = Logger.getLogger(AuthService.class.getName());

    public onboardingResponse userOnbording(User user) {
        School userSchool = user.getSchool();
        if (userSchool == null) {
            return new onboardingResponse(false, 0);
        }
        SchoolClassesResponse schoolExams = schoolClassesService.getSchoolClasses(userSchool.getId());
        if (schoolExams.schoolMajors().isEmpty() && schoolExams.schoolOptionalSubjects().isEmpty()) {
            return new onboardingResponse(false, 1);
        }
        return new onboardingResponse(true, 2);
    }

    public UserProfileResponse createUser(FirebaseToken firebaseToken) {

        if (usersRepo.existsByEmail(firebaseToken.getEmail())) {
            throw new IllegalArgumentException("User with email " + firebaseToken.getEmail() + " already exists.");
        }

        String userId = firebaseToken.getUid();

        User userEntity = User.builder()
                .id(userId)
                .username(firebaseToken.getName())
                .email(firebaseToken.getEmail())
                .signInProvider(getSignInProvider(firebaseToken))
                .role(RoleEnums.ADMIN)
                .build();

        User savedUser = usersRepo.save(userEntity);

        firebaseService.setCustomClaims(userId.toString(), savedUser.getRole(), null);

        onboardingResponse userOnboarding = userOnbording(savedUser);
        UserProfileResponse userResponse = userMapper.toUserProfile(savedUser, firebaseToken, userOnboarding);
        return userResponse;
    }

    public UserProfileResponse loginWithPassword(FirebaseToken firebaseToken) {

        String userEmail = firebaseToken.getEmail();

        Optional<User> optionalUser = usersRepo.findByEmail(userEmail);

        if (optionalUser.isEmpty()) {
            // * this part is incase register didnt go through post registration in
            // fireabse, shit happens you know, at least make some logging to catch it to be
            // aware if it ever happended in prod
            return this.addUser(firebaseToken);
        }

        User userEntity = optionalUser.get();
        var claims = firebaseToken.getClaims();
        if (claims == null) {
            claims = Collections.emptyMap();
        }

        Object roleClaim = claims.get("role");
        if (!Objects.equals(roleClaim, userEntity.getRole().name())) {
            // TODO : set other claims like schoolId
            firebaseService.setCustomClaims(userEntity.getId(), userEntity.getRole(), null);
        }
        onboardingResponse userOnboarding = userOnbording(userEntity);
        UserProfileResponse userResponse = userMapper.toUserProfile(userEntity, firebaseToken, userOnboarding);
        return userResponse;
    }

    public UserProfileResponse addUser(FirebaseToken firebaseToken) {

        String userId = firebaseToken.getUid();

        User userEntity = User.builder()
                .id(userId)
                .username(firebaseToken.getName())
                .email(firebaseToken.getEmail())
                .signInProvider(getSignInProvider(firebaseToken))
                .role(RoleEnums.ADMIN)
                .build();

        firebaseService.setCustomClaims(userId, userEntity.getRole(), null);

        User savedUser = usersRepo.save(userEntity);

        onboardingResponse userOnboarding = userOnbording(savedUser);
        UserProfileResponse userResponse = userMapper.toUserProfile(savedUser, firebaseToken, userOnboarding);
        return userResponse;
    }

    @SuppressWarnings("unchecked")
    public String getSignInProvider(FirebaseToken firebaseToken) {
        var claims = firebaseToken.getClaims();
        Map<String, Object> firebaseMap = (Map<String, Object>) claims.get("firebase");
        String signInProvider = firebaseMap.get("sign_in_provider").toString();
        return signInProvider;
    }

    public UserProfileResponse authenticateWithProvider(FirebaseToken firebaseToken) {
        String userEmail = firebaseToken.getEmail();
        Optional<User> user = usersRepo.findByEmail(userEmail);
        if (user.isEmpty()) {

            return this.addUser(firebaseToken);
        }

        var claims = firebaseToken.getClaims();
        if (claims == null) {
            claims = Collections.emptyMap();
        }
        String userRole = user.get().getRole().name();
        Object tokenRole = claims.get("role");
        boolean missingOrOutdatedRole = (tokenRole == null) || !tokenRole.equals(userRole);

        if (missingOrOutdatedRole) {
            // TODO : set other claims like schoolId
            firebaseService.setCustomClaims(user.get().getId(), user.get().getRole(), null);
        }

        onboardingResponse userOnboarding = userOnbording(user.get());
        UserProfileResponse userResponse = userMapper.toUserProfile(user.get(), firebaseToken, userOnboarding);
        return userResponse;
    }

    public UserProfileResponse getCurrentUser(FirebaseToken firebaseToken) {
        String userId = AuthenticationUtils.getCurrentUserId();
        logger.info("Getting current user with ID: " + userId);
        User user = usersRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with id not found."));

        onboardingResponse userOnboarding = userOnbording(user);
        UserProfileResponse userResponse = userMapper.toUserProfile(user, firebaseToken, userOnboarding);
        return userResponse;
    }

}
