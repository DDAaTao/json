package com.xxs.json.service;

import com.xxs.json.entity.BaseUser;

/**
 * @author van
 */
public interface BaseUserService {

    /**
     * 添加用户方法
     * @param user 用户
     * */
    void addUser(BaseUser user);

    /**
     * 用户登录
     * @param baseUser 账户和密码
     * @return baseUser
     * */
    BaseUser userLogin(BaseUser baseUser);
}
