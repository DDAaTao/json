package com.xxs.json.common.util;

import com.xxs.json.common.BaseConstant;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author van
 */
public class CacheMapUtils {

    /**
     * 使用 private 修饰构造方法很少用，单例模式会这样使用
     * */
    private CacheMapUtils(){
        cacheMapUtils = new CacheMapUtils();
    }

    private static CacheMapUtils cacheMapUtils = new CacheMapUtils();

    public static CacheMapUtils getInstance(){
        return cacheMapUtils;
    }

    /**
     * 使用缓存存用户token, key 使用了 springEL表达式，为传入的key -> userId
     * */
    @CachePut(value = "USER_TOKEN", key = "#key")
    public String putUserToken(Long key, String value){
        return value;
    }

    /**
     * 如果获取缓存失败，则返回 NOT_CACHED_CODE
     * */
    @Cacheable(value = "USER_TOKEN", key = "#key")
    public String getUserToken(Long key){
        return BaseConstant.NOT_CACHED_CODE;
    }

}
