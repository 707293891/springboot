package com.yinhai.yunwei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author fanchao
 */
@EnableScheduling
@SpringBootApplication
public class YunweiApplication {

    public static void main(String[] args) {
        SpringApplication.run(YunweiApplication.class, args);
    }
}
