package com.xxs.json.service;

import com.xxs.json.common.JsonGroupException;
import com.xxs.json.entity.TextBody;
import com.xxs.json.entity.TextLabel;
import com.xxs.json.entity.vo.TextLabelVO;

import java.util.List;

/**
 * @author van
 */
public interface TextMainService {

    /**
     * 通过userId获取对应的label
     * @param userId userId
     * @return labels
     * */
    List<TextLabelVO> getTextLabelByUser(Long userId);

    /**
     * 通过userId获取对应的label
     * @param userId userId
     * @return labels
     * */
    List<TextLabelVO> getTextLabelByUserTwo(Long userId);
    /**
     * 通过userId获取对应的text
     * @param userId userId
     * @return texts
     * */
    List<TextBody> getTextBodyByUser(Long userId);

    /**
     * 通过textId获取对应的文本
     * @param textId textId
     * @return textBody
     * */
    TextBody getTextBodyByTextId(Long textId);
    /**
     * 新增笔记
     * @param text 笔记
     * @exception JsonGroupException 自定异常类
     * */
    void addTextBody(TextBody text) throws JsonGroupException;
    /**
     * 新增侧栏
     * @param label 侧栏
     * @exception JsonGroupException 自定异常类
     * */
    void addTextLabel(TextLabel label) throws JsonGroupException;
}
