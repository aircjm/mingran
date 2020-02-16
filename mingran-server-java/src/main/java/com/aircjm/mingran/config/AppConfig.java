package com.aircjm.mingran.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(value = {"com.aircjm.mingran.mapper"})
public class AppConfig {
}
