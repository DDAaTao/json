package com.xxs.json.service.impl;

import com.xxs.json.common.util.DateUtils;
import com.xxs.json.common.util.MD5Utils;
import com.xxs.json.dao.BaseUserDao;
import com.xxs.json.entity.BaseUser;
import com.xxs.json.entity.vo.UserVO;
import com.xxs.json.service.BaseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

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
        // 注册时间getTime()当作盐
        String password= MD5Utils.getPassword(user.getPassword() + user.getGmtCreate().getTime());
        user.setPassword(password);
        baseUserDao.addUser(user);
    }

    @Override
    public UserVO userLogin(BaseUser baseUser) {
        BaseUser user = baseUserDao.getUser(baseUser.getAccount());
        // 卫语句
        if (user == null){
            return null;
        }
        String password = MD5Utils.getPassword(baseUser.getPassword() + user.getGmtCreate().getTime());
        // 卫语句
        if (!password.equals(user.getPassword())){
            return null;
        }
        baseUserDao.updateUser(BaseUser.builder()
                .id(user.getId()).lastLoginTime(user.getLastLoginTime()).build());
        return UserVO.builder()
                .nickname(user.getNickname())
                .avator(user.getAvator())
                .email(user.getEmail())
                .lastLoginTime(user.getLastLoginTime())
                .sex(user.getSex())
                .status(user.getStatus())
                .build();
    }
}
