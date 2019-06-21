package com.tutorial.aop.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserService {

//    @Profilable
    public void addUser()
            throws InterruptedException {
        Thread.sleep( 5000 );
    }

//    @Profilable
    public void updateUser()
            throws InterruptedException {
        Thread.sleep( 2000 );
    }

//    @Profilable
    public void deleteUser()
            throws InterruptedException {
        Thread.sleep( 3000 );
    }
}
