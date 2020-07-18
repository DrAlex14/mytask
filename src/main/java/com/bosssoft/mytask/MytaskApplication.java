package com.bosssoft.mytask;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.bosssoft.mytask.dao")
@SpringBootApplication
public class MytaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(MytaskApplication.class, args);
    }

}
