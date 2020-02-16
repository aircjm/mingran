package com.aircjm.mingran.controller;

import com.aircjm.mingran.domain.User;
import com.aircjm.mingran.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 技术支持Controller
 *
 * @author aircjm
 */
@RestController
@RequestMapping(value = "/api/ts")
public class TsController {

    @Resource
    private UserMapper userMapper;


    @GetMapping(value = "/testAlive")
    public String testAlive() {
        UpdateWrapper<User> tWrapper = new UpdateWrapper<>();
        userMapper.selectCount(tWrapper);
        return "当前服务alive";
    }


}
