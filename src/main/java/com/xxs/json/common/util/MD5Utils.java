package com.xxs.json.common.util;

import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

/**
 * @author van
 */
public class MD5Utils {
    public static String getPassword(String string){
        if (StringUtils.isEmpty(string)){
            return string;
        }
        byte[] bytes = DigestUtils.md5Digest(string.getBytes());
        StringBuilder stringBuffer = new StringBuilder();
        for (byte aByte : bytes) {
            stringBuffer.append(aByte);
        }
        return stringBuffer.toString();
    }
}
