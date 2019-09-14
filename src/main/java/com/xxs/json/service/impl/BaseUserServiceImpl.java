package com.xxs.json.service.impl;

import com.xxs.json.common.util.DateUtils;
import com.xxs.json.dao.BaseUserDao;
import com.xxs.json.entity.BaseUser;
import com.xxs.json.service.BaseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author van
 */
@Service
public class BaseUserServiceImpl implements BaseUserService {

    @Autowired
    private BaseUserDao baseUserDao;

    @Override
    public void addUser(BaseUser user) {
        user.setGmtCreate(DateUtils.now());
        user.setGmtModified(DateUtils.now());
        baseUserDao.addUser(user);
    }

    @Override
    public BaseUser userLogin(BaseUser baseUser) {
        BaseUser user = baseUserDao.getUser(baseUser.getAccount());
        if (user == null){
            return null;
        }

        return null;
    }
}
