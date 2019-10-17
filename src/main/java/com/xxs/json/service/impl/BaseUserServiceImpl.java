package com.xxs.json.service.impl;

import com.xxs.json.common.JsonGroupException;
import com.xxs.json.common.util.CacheMapUtils;
import com.xxs.json.common.util.DateUtils;
import com.xxs.json.common.util.MD5Utils;
import com.xxs.json.dao.BaseUserDao;
import com.xxs.json.entity.BaseUser;
import com.xxs.json.entity.vo.UserVO;
import com.xxs.json.service.BaseUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static com.xxs.json.common.ResultCode.*;

/**
 * @author van
 */
@Slf4j
@Service
public class BaseUserServiceImpl implements BaseUserService {

    @Autowired
    private BaseUserDao baseUserDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addUser(BaseUser user) throws JsonGroupException {
        // 先判断账户是否重复
        BaseUser userByAccount = baseUserDao.getUser(user.getAccount());
        if (userByAccount != null){
            throw new JsonGroupException(ADD_USER_ERROR.getCode(), "该账户已存在！");
        }
        user.setGmtCreate(DateUtils.now());
        user.setGmtModified(DateUtils.now());
        // 注册时间getTime()当作盐
        String password= MD5Utils.getPassword(user.getPassword() + DateUtils.getDayStartTime(user.getGmtCreate()).getTime());
        user.setPassword(password);
        baseUserDao.addUser(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserVO userLogin(BaseUser baseUser) throws JsonGroupException {
        BaseUser user = baseUserDao.getUser(baseUser.getAccount());
        // 卫语句
        if (user == null){
            return null;
        }
        String password = MD5Utils.getPassword(baseUser.getPassword() + DateUtils.getDayStartTime(user.getGmtCreate()).getTime());
        // 卫语句
        if (!password.equals(user.getPassword())){
            throw new JsonGroupException(USER_LOGIN_ERROR.getCode(), "账户/密码错误");
        }
        baseUserDao.updateUser(BaseUser.builder()
                .id(user.getId()).lastLoginTime(user.getLastLoginTime()).build());
        String token = UUID.randomUUID().toString();
        CacheMapUtils.getInstance().putUserToken(user.getId(), token);
        return UserVO.builder()
                .userId(user.getId())
                .nickname(user.getNickname())
                .avator(user.getAvator())
                .email(user.getEmail())
                .lastLoginTime(user.getLastLoginTime())
                .sex(user.getSex())
                .status(user.getStatus())
                .token(token)
                .build();
    }
}
