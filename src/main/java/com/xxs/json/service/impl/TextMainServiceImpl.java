package com.xxs.json.service.impl;

import com.xxs.json.common.BaseConstant;
import com.xxs.json.common.JsonGroupException;
import com.xxs.json.common.util.DateUtils;
import com.xxs.json.dao.TextBodyDao;
import com.xxs.json.dao.TextLabelDao;
import com.xxs.json.entity.TextBody;
import com.xxs.json.entity.TextLabel;
import com.xxs.json.service.TextMainService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author van
 */
public class TextMainServiceImpl implements TextMainService {

    @Autowired
    private TextBodyDao textBodyDao;

    @Autowired
    private TextLabelDao textLabelDao;

    @Override
    public List<TextLabel> getTextLabelByUser(Long userId) {
        return null;
    }

    @Override
    public List<TextBody> getTextBodyByUser(Long userId) {
        return textBodyDao.getTextBodyByUser(userId);
    }

    @Override
    public void addTextBody(TextBody text) throws JsonGroupException {
        text.setGmtCreate(DateUtils.now());
        text.setGmtModified(DateUtils.now());
        text.setIsDeleted(false);
        if (!BaseConstant.INSERT_FLAG.equals(textBodyDao.addTextBody(text))){
            throw new JsonGroupException("新增笔记失败");
        }
    }

    @Override
    public void addTextLabel(TextLabel label) throws JsonGroupException {
        label.setGmtCreate(DateUtils.now());
        label.setGmtModified(DateUtils.now());
        if (!BaseConstant.INSERT_FLAG.equals(textLabelDao.addTextLabel(label))){
            throw new JsonGroupException("新增侧栏失败");
        }
    }
}
