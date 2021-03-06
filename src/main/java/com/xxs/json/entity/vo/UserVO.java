package com.xxs.json.entity.vo;

import lombok.*;

import java.util.Date;

/**
 * @author van
 */
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
    private Long userId;
    private String nickname;
    private String email;
    private String status;
    /**
     * 头像
     * */
    private String avator;
    private Byte sex;
    private Date lastLoginTime;
    /**
     * 登录令牌
     * */
    private String token;
}
