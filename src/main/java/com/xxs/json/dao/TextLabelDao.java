package com.xxs.json.dao;

import com.xxs.json.entity.TextLabel;

import java.util.List;

/**
 * @author van
 */
public interface TextLabelDao {
    /**
     * 添加
     * @param textLabel label
     * @return  标识
     * */
    Integer addTextLabel(TextLabel textLabel);

    /**
     * 通过userId获取其对应的label
     * @param userId userId
     * @return labels
     * */
    List<TextLabel> getTextLabelsByUser(Long userId);

    /**
     * 修改节点信息
     * @param label fatherById
     * @return num
     * */
    int updateLabel(TextLabel label);

    /**
     * 删除节点
     * @param id id
     * @return num
     * */
    int deleteLabel(Long id);
}
