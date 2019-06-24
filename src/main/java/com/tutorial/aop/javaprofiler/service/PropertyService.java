package com.tutorial.aop.javaprofiler.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PropertyService {

    //    @Profilable
    public void addProperty()
            throws InterruptedException {
        Thread.sleep( 2231 );
    }

    //    @Profilable
    public void updateProperty()
            throws InterruptedException {
        Thread.sleep( 1220 );
    }

    //    @Profilable
    public void deleteProperty()
            throws InterruptedException {
        Thread.sleep( 4243 );
    }
}
