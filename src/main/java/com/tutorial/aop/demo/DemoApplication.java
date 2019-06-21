package com.tutorial.aop.demo;

import com.tutorial.aop.demo.service.ContentService;
import com.tutorial.aop.demo.service.PropertyService;
import com.tutorial.aop.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private final UserService userService;

    private final ContentService contentService;

    private final PropertyService propertyService;

    @Autowired
    public DemoApplication( UserService userService, ContentService contentService, PropertyService propertyService ) {
        this.userService = userService;
        this.contentService = contentService;
        this.propertyService = propertyService;
    }

    public static void main( String[] args ) {
        SpringApplication.run( DemoApplication.class, args );
    }

    @Override
    public void run( String... args )
            throws Exception {
        userService.addUser();
        userService.updateUser();
        userService.deleteUser();

        contentService.addContent();
        contentService.updateContent();
        contentService.deleteContent();

        userService.addUser();
        userService.updateUser();
        userService.deleteUser();

        contentService.addContent();
        contentService.updateContent();
        contentService.deleteContent();

        propertyService.addProperty();
        propertyService.updateProperty();
        propertyService.deleteProperty();
    }
}
