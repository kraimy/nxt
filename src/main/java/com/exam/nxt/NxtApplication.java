package com.exam.nxt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@MapperScan("com.exam.nxt.mapper")
public class NxtApplication {

    public static void main(String[] args) {
        SpringApplication.run(NxtApplication.class, args);
    }

    @GetMapping
    public String kk() {
        return "看看";
    }
}
