package com.xxs.json;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author van
 *
 * EnableCaching注释触发一个后处理器(post processor )
 * 它检查每个Spring bean是否存在公共方法(public method)上的缓存注释。
 * 如果找到这样的注释，则自动创建代理以拦截方法调用并相应地处理缓存行为。
 */
@EnableCaching
@MapperScan("com.xxs.json.mapper")
@SpringBootApplication(exclude={DruidDataSourceAutoConfigure.class})
public class JsonApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsonApplication.class, args);
        System.out.println("项目启动成功！");
    }

}
