package com.xxs.json.dao;

import com.xxs.json.entity.BaseConfig;

/**
 * @author van
 */
public interface BaseConfigDao {
    /**
     * 通过ConfigName获取配置
     * @param configName name
     * @return 如果查不到，返回null
     * */
    BaseConfig getBaseConfigByName(String configName);

    /**
     * 获取当前环境标识，需要注意循环依赖问题
     * @return env
     * */
    String getEnv();
}
