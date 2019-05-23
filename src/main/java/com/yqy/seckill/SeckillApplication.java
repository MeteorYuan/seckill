package com.yqy.seckill;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.yqy.seckill")//包括@ComponentScan，和@SpringBootConfiguration，@EnableAutoConfiguration。
@MapperScan("com.yqy.seckill.dao")
public class SeckillApplication {
    public static void main(String[] args) {
        SpringApplication.run(SeckillApplication.class, args);
    }

}
