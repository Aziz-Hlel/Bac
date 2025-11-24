package com.tigana.Seeders;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tigana.Enums.CityEnums;
import com.tigana.Enums.RoleEnums;
import com.tigana.School.Model.School;
import com.tigana.School.Repo.SchoolRepo;
import com.tigana.Users.Model.User;
import com.tigana.Users.Repositry.UsersRepo;
import com.tigana.Utils.AppConstants;
import com.tigana.Utils.AppProperties;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
@Transactional
@Profile("devv")
public class DataBaseSeeder implements CommandLineRunner {

        private final UsersRepo usersRepo;
        private final SchoolRepo schoolRepo;
        private final AppProperties appProperties;

        @Override
        public void run(String... args) throws Exception {

                log.info("Seeding database...");

                User superAdminEntity = User.builder()
                                .username("superadmin")
                                // .password("superadmin")
                                .school(null)
                                .role(RoleEnums.SUPER_ADMIN)
                                .build();

                User superAdmin = usersRepo.save(superAdminEntity);

                User adminEntity = User.builder()
                                .username("admin")
                                // .password("admin")
                                .role(RoleEnums.ADMIN)
                                .build();

                School schoolEntity = School.builder()
                                .publicId("schoolTestPublicId")
                                .name("school test")
                                .city(CityEnums.SOUSSE)
                                .address("khzema")
                                .build();

                School school = schoolRepo.save(schoolEntity);

                adminEntity.setSchool(school);
                User admin = usersRepo.save(adminEntity);

                AppConstants.userId = admin.getId();
                AppConstants.schoolId = admin.getSchool().getId();

                log.info("super admin id : {}", superAdmin.getId().toString());
                log.info("admin id : {}", admin.getId());
                log.info("school id : {}", school.getId());

        }

}
