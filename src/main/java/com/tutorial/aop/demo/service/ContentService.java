package com.tutorial.aop.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ContentService {

    //    @Profilable
    public void addContent()
            throws InterruptedException {
        Thread.sleep( 2231 );
    }

    //    @Profilable
    public void updateContent()
            throws InterruptedException {
        Thread.sleep( 1220 );
    }

    //    @Profilable
    public void deleteContent()
            throws InterruptedException {
        Thread.sleep( 4243 );
    }
}
