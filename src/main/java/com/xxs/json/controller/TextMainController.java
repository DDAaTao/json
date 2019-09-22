package com.xxs.json.controller;

import com.xxs.json.common.AjaxResult;
import com.xxs.json.entity.TextBody;
import com.xxs.json.service.TextMainService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author van
 */
@Controller
@CrossOrigin
public class TextMainController {
    @Autowired
    private TextMainService textMainService;

    @GetMapping("/text/all")
    @ResponseBody
    public AjaxResult getUserTexts(@Param("userId")Long userId){
        return AjaxResult.success(textMainService.getTextBodyByUser(userId));
    }

    @GetMapping("/label/all")
    @ResponseBody
    public AjaxResult getUserLabels(@Param("userId")Long userId){
        return AjaxResult.success(textMainService.getTextLabelByUser(userId));
    }


}
