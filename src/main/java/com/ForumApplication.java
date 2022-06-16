package com;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@ServletComponentScan
@EnableScheduling
@SpringBootApplication
@MapperScan({"com.mapper"})
public class ForumApplication {

    private static Logger log = LogManager.getLogger(ForumApplication.class);

    public static void main(String[] args) {
        // 启动时间计时
        long startTime = System.currentTimeMillis();
        // 启动项目
        SpringApplication.run(ForumApplication.class, args);
        // 输出启动时间
        log.error("启动完成，耗时：" + (System.currentTimeMillis() - startTime) / 1000.0 + "秒");
    }

}