package com.k8s.service.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@Slf4j
public class ServiceConfiguration {

    public ServiceConfiguration() {
        log.info("ServiceConfiguration initialized");
    }
}