package com.example.springboot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

// 标志该类是Spring核心配置类
@Configuration
@ComponentScan("com.example.springboot")
@Import(DataSourceConfiguration.class)
public class SpringCofiguration {
}
