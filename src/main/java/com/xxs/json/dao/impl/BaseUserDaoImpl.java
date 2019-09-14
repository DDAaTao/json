package com.xxs.json.dao.impl;

import com.xxs.json.common.util.DateUtils;
import com.xxs.json.dao.BaseConfigDao;
import com.xxs.json.dao.BaseUserDao;
import com.xxs.json.entity.BaseUser;
import com.xxs.json.entity.BaseUserExample;
import com.xxs.json.mapper.BaseUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author van
 */
@Service
public class BaseUserDaoImpl implements BaseUserDao {

    @Autowired
    private BaseUserMapper mapper;

    @Autowired
    private BaseConfigDao baseConfigDao;

    @Override
    public void addUser(BaseUser user) {
        user.setEnv(baseConfigDao.getEnv());
        mapper.insertSelective(user);
    }

    @Override
    public BaseUser getUser(String account) {
        BaseUserExample baseUserExample = new BaseUserExample();
        baseUserExample.createCriteria().andAccountEqualTo(account);
        List<BaseUser> baseUsers = mapper.selectByExample(baseUserExample);
        return CollectionUtils.isEmpty(baseUsers) ? null : baseUsers.get(0);
    }

    @Override
    public void updateUser(BaseUser user) {
        user.setGmtModified(DateUtils.now());
        mapper.updateByPrimaryKeySelective(user);
    }
}
