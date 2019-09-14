package com.xxs.json.dao;

import com.xxs.json.entity.BaseUser;

/**
 * @author van
 */
public interface BaseUserDao {
    /**
     * 添加用户
     * @param user 用户
     * */
    void addUser(BaseUser user);

    /**
     * 获取用户信息
     * @param account 账户
     * @return user
     * */
    BaseUser getUser(String account);
}
