package com.mingran.project.system;

import com.mingran.project.system.mapper.SysConfigMapper;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * 用户系统配置
 *
 * @author aircjm
 */
public class SystemConfigConstants {





    @Resource
    private SysConfigMapper sysConfigMapper;


    @Bean
    private SystemConfigConstants init() {

        SystemConfigConstants configConstants = new SystemConfigConstants();



        return configConstants;

    }


}
