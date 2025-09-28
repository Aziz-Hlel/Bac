package com.tigana.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class serviceTest {


    @Autowired
    private repoTest repoTest;


    public void createTest(String name) {
        entityTest entityTest = new entityTest();
        entityTest.setName(name);
        repoTest.save(entityTest);

    }
}
