package com.aircjm.mingran.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户信息
 *
 * @author aircjm
 */
@Data
public class User {

    @TableId
    private Long id;

    /**
     * 账号
     */
    private String username;

    /**
     * 用户密码 md5存储
     */
    private String passwordMd5;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户显示名称
     */
    private String screenName;

    /**
     * 用户创建时间
     */
    private LocalDateTime created;

    /**
     * 最后登陆时间
     */
    private LocalDateTime logged;


    @TableField(exist = false)
    private List<Integer> roleIds;
}
