package com.xxs.json.common;

import lombok.Getter;

/**
 * @author van
 */
public enum ConfigEnum {
    /**
     * 获取环境标识信息
     * */
    ENV("env","env","环境标识");



    /**
     * 配置组
     * */
    @Getter
    private String configGroup;
    /**
     * 配置名称
     * */
    @Getter
    private String configName;
    /**
     * 配置描述
     * */
    @Getter
    private String configDescription;


    ConfigEnum() {
    }

    ConfigEnum(String configGroup, String configName, String configDescription) {
        this.configGroup = configGroup;
        this.configName = configName;
        this.configDescription = configDescription;
    }
}
