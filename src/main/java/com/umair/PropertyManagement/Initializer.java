package com.umair.PropertyManagement;

import com.umair.PropertyManagement.services.InitializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Initializer implements ApplicationRunner {

    @Autowired
    InitializationService initializationService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        initializationService.initialize();
    }
}
