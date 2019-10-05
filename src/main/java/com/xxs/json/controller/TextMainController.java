package com.xxs.json.controller;

import com.xxs.json.common.AjaxResult;
import com.xxs.json.entity.TextBody;
import com.xxs.json.service.TextMainService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


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
    /**
     * 通过文本id去获取文本
     * */
    @GetMapping
    @ResponseBody
    public AjaxResult getUserTextById(@Param("textId")Long textId){
        return AjaxResult.success(textMainService.getTextBodyByTextId(textId));
    }

    /**
     * todo 需要考虑安全与时效问题，是否可以通过session控制？
     * */
    @GetMapping("/label/all")
    @ResponseBody
    public AjaxResult getUserLabels(@Param("userId")Long userId){
        return AjaxResult.success(textMainService.getTextLabelByUserTwo(userId));
    }


}
