package com.lhb.study.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lianghuaibin
 * @since 2017/6/9
 */
/*@Configuration
@ComponentScan(basePackages = { "com.lhb.study.springBoot" })
@EnableAutoConfiguration*/
//@ImportResource(locations={"classpath:application-bean.xml"})
@SpringBootApplication(scanBasePackages = {"com.lhb.study"} ) //代替以上三个注解
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
