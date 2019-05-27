package com.zhaoyangyingmu.usercommon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zhaoyangyingmu.usercommon.dao")
public class UserCommonBehaviorApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserCommonBehaviorApplication.class, args);
    }

}
