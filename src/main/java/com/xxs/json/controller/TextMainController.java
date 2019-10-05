package com.xxs.json.controller;

import com.xxs.json.common.AjaxResult;
import com.xxs.json.common.JsonGroupException;
import com.xxs.json.common.ResultCode;
import com.xxs.json.entity.TextBody;
import com.xxs.json.entity.TextLabel;
import com.xxs.json.entity.vo.LabelChangeVO;
import com.xxs.json.service.TextMainService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @author van
 */
@Slf4j
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

    /**
     * 修改节点的父节点信息
     * */
    @PostMapping("/label/change")
    @ResponseBody
    public AjaxResult changeLabelFather(@RequestBody LabelChangeVO vo){
        if (textMainService.changeLabelFather(vo) != 1){
            return AjaxResult.fail(ResultCode.SYSTEM_ERROR.getCode(), "修改失败");
        }
        return AjaxResult.success();
    }

    /**
     * 修改节点信息
     * */
    @PostMapping("/label/update")
    @ResponseBody
    public AjaxResult updateLabel(@RequestBody TextLabel label){
        if (textMainService.updateLabel(label) != 1){
            return AjaxResult.fail(ResultCode.SYSTEM_ERROR.getCode(), "修改失败");
        }
        return AjaxResult.success();
    }

    /**
     * 新增label
     * */
    @PostMapping("/label/add")
    @ResponseBody
    public AjaxResult addLabel(@RequestBody TextLabel label){
        try {
            textMainService.addTextLabel(label);
        } catch (JsonGroupException e) {
            log.error("新增侧栏失败");
            return AjaxResult.fail(ResultCode.SYSTEM_ERROR.getCode(), e.getMessage());
        }
        return AjaxResult.success();
    }
    /**
     * 新增或修改label，根据id是否存在动态判断
     * */
    @PostMapping("/label/addOrUpdate")
    @ResponseBody
    public AjaxResult addOrUpdateLabel(@RequestBody TextLabel label){
        if (label.getId() == null){
            try {
                textMainService.addTextLabel(label);
            } catch (JsonGroupException e) {
                log.error("新增侧栏失败");
                return AjaxResult.fail(ResultCode.SYSTEM_ERROR.getCode(), e.getMessage());
            }
        }else {
            if (textMainService.updateLabel(label) != 1){
                return AjaxResult.fail(ResultCode.SYSTEM_ERROR.getCode(), "修改侧栏失败");
            }
        }
        return AjaxResult.success();
    }

    /**
     * 删除侧栏
     * */
    @GetMapping("/label/delete")
    @ResponseBody
    public AjaxResult deleteLabel(@Param("id")Long id){
        if (textMainService.deleteLabel(id) != 1){
            return AjaxResult.fail(ResultCode.SYSTEM_ERROR.getCode(), "删除失败");
        }
        return AjaxResult.success();
    }

    /**
     * 新增text,id为labelId
     * */
    @PostMapping("/text/add")
    @ResponseBody
    public AjaxResult addTextBody(@RequestBody TextBody body){
        try {
            textMainService.addTextBody(body);
        } catch (JsonGroupException e) {
            return AjaxResult.fail(ResultCode.SYSTEM_ERROR.getCode(), e.getMessage());
        }
        return AjaxResult.success();
    }

    /**
     * 保存text
     * */
    @PostMapping("/text/save")
    @ResponseBody
    public AjaxResult saveTextBody(@RequestBody TextBody body){
        if (textMainService.saveTextBody(body) != 1){
            return AjaxResult.fail(ResultCode.SYSTEM_ERROR.getCode(), "保存失败");
        }
        return AjaxResult.success();
    }

}
