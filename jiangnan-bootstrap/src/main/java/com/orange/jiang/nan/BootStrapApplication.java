package com.orange.jiang.nan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author xieyong
 * @date 2019/11/5
 * @Description: 采用war包的形式启动AdminApplication需要继承SpringBootServletInitializer
 */
@SpringBootApplication(scanBasePackages = {"com.orange.jiang.nan"})
@MapperScan(basePackages = {"com.orange.jiang.nan.*.infrastructure.dao.mapper"})
@EnableSwagger2
public class BootStrapApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(BootStrapApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(BootStrapApplication.class);
    }
}
