package com.lhb.study.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author lianghuaibin
 * @since 2017/6/9
 */
/*@Configuration
@ComponentScan(basePackages = { "com.lhb.study.springBoot" })
@EnableAutoConfiguration*/
@ImportResource(locations={"spring-config-datasource.xml"})
@SpringBootApplication(scanBasePackages = {"com.lhb.study"} ) //代替以上三个注解
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
