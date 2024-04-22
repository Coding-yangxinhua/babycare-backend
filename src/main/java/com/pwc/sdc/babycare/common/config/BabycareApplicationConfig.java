package com.pwc.sdc.babycare.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.pwc.sdc.babycare.mapper")
@EnableCaching
public class BabycareApplicationConfig {

}