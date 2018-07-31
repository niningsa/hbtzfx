package com.hbtzfx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.hbtzfx"})
@MapperScan(basePackages = {"com.hbtzfx.dao"})
public class TelApplication {

    public static void main(String[] args) {
        SpringApplication.run(TelApplication.class, args);
    }
}
