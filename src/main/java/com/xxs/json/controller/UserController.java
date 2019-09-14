package com.xxs.json.controller;

import com.xxs.json.common.AjaxResult;
import com.xxs.json.entity.BaseUser;
import com.xxs.json.service.BaseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author van
 */
@Controller
public class UserController {

    @Autowired
    private BaseUserService baseUserService;

    @PostMapping("/user/registered")
    @ResponseBody
    public AjaxResult userRegistered(@RequestBody BaseUser user){
        baseUserService.addUser(user);
        return AjaxResult.success();
    }

}
