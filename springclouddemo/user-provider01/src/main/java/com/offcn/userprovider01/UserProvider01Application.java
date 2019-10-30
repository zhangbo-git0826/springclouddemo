package com.offcn.userprovider01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserProvider01Application {

    public static void main(String[] args) {
        SpringApplication.run(UserProvider01Application.class, args);
    }

}
