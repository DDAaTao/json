package com.xxs.json.dao.impl;

import com.xxs.json.common.ConfigEnum;
import com.xxs.json.dao.BaseConfigDao;
import com.xxs.json.entity.BaseConfig;
import com.xxs.json.entity.BaseConfigExample;
import com.xxs.json.mapper.BaseConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author van
 */
@Service
public class BaseConfigDaoImpl implements BaseConfigDao {

    @Autowired
    private BaseConfigMapper mapper;

    @Override
    public BaseConfig getBaseConfigByName(String configName) {
        BaseConfigExample example = new BaseConfigExample();
        example.createCriteria()
                .andConfigNameEqualTo(configName)
                .andEnvEqualTo(getEnv())
                .andIsDeletedEqualTo(false);
        List<BaseConfig> baseConfigs = mapper.selectByExample(example);
        return CollectionUtils.isEmpty(baseConfigs) ? null : baseConfigs.get(0);
    }

    @Override
    public String getEnv() {
        BaseConfigExample example = new BaseConfigExample();
        example.createCriteria()
                .andConfigNameEqualTo(ConfigEnum.ENV.getConfigName())
                .andIsDeletedEqualTo(false);
        List<BaseConfig> baseConfigs = mapper.selectByExample(example);
        return CollectionUtils.isEmpty(baseConfigs) ? null : baseConfigs.get(0).getConfigBody();
    }
}
