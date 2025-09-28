package com.tigana.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repoTest extends JpaRepository<entityTest, Integer> {

}
