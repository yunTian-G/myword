package com.yuntian.myworld;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.yuntian")
@MapperScan(value = "com.yuntian.mapper")
public class MyworldApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyworldApplication.class, args);
    }

}
