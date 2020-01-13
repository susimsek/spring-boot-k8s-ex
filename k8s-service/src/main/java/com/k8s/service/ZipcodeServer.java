package com.k8s.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ZipcodeServer {


    public static void main(String[] args) {
        if (args.length > 0 && args.length != 1) {
            errorMessage();
            return;
        } else if (args.length == 1) {
            System.setProperty("server.port", args[0]);
        }
        System.setProperty("spring.config.name", "zipcodeservice-server");
        SpringApplication.run(ZipcodeServer.class, args);
    }
    protected static void errorMessage() {
        System.out.println("Usage: java -jar [jar file name] <port> OR");
        System.out.println("Usage: java -jar [jar file name]");
    }
}