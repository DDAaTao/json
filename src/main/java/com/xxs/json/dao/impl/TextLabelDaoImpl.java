package com.xxs.json.dao.impl;

import com.xxs.json.dao.BaseConfigDao;
import com.xxs.json.dao.TextLabelDao;
import com.xxs.json.entity.TextLabel;
import com.xxs.json.entity.TextLabelExample;
import com.xxs.json.mapper.TextLabelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author van
 */
@Service
public class TextLabelDaoImpl implements TextLabelDao {

    @Autowired
    private TextLabelMapper textLabelMapper;

    @Autowired
    private BaseConfigDao baseConfigDao;

    @Override
    public Integer addTextLabel(TextLabel textLabel) {
        textLabel.setEnv(baseConfigDao.getEnv());
        return textLabelMapper.insertSelective(textLabel);
    }

    @Override
    public List<TextLabel> getTextLabelsByUser(Long userId) {
        TextLabelExample textLabelExample = new TextLabelExample();
        textLabelExample.createCriteria()
                .andUserIdEqualTo(userId)
                .andEnvEqualTo(baseConfigDao.getEnv());
        return textLabelMapper.selectByExample(textLabelExample);
    }
}
