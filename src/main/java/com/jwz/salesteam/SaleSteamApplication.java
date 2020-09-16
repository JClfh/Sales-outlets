package com.jwz.salesteam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.jwz.salesteam.dao")
@SpringBootApplication
public class SaleSteamApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaleSteamApplication.class, args);
    }

}
