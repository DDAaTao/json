package com.xxs.json.dao;

import com.xxs.json.entity.TextBody;

import java.util.List;

/**
 * @author van
 */
public interface TextBodyDao {

    /**
     * 通过userId获取其对应的TextBody
     * @param userId userId
     * @return texts
     * */
    List<TextBody> getTextBodyByUser(Long userId);

    /**
     * 通过userId获取其对应的TextBody
     * @param textId textId
     * @return text
     * */
    TextBody getTextBodyByTextId(Long textId);

    /**
     * 新增
     * @param textBody textBody
     * @return 标识
     * */
    int addTextBody(TextBody textBody);

    /**
     * 修改/保存
     * @param textBody text
     * @return num
     * */
    int updateTextBody(TextBody textBody);

}
