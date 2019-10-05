package com.xxs.json.dao.impl;

import com.xxs.json.dao.BaseConfigDao;
import com.xxs.json.dao.TextBodyDao;
import com.xxs.json.entity.TextBody;
import com.xxs.json.entity.TextBodyExample;
import com.xxs.json.mapper.TextBodyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author van
 */
@Service
public class TextBodyDaoImpl implements TextBodyDao {

    @Autowired
    private TextBodyMapper textBodyMapper;

    @Autowired
    private BaseConfigDao baseConfigDao;

    @Override
    public List<TextBody> getTextBodyByUser(Long userId){
        TextBodyExample textBodyExample = new TextBodyExample();
        textBodyExample.createCriteria()
                .andUserIdEqualTo(userId)
                .andEnvEqualTo(baseConfigDao.getEnv())
                .andIsDeletedEqualTo(false);
        return textBodyMapper.selectByExample(textBodyExample);
    }

    @Override
    public TextBody getTextBodyByTextId(Long textId) {
        TextBodyExample textBodyExample = new TextBodyExample();
        textBodyExample.createCriteria()
                .andIdEqualTo(textId)
                .andEnvEqualTo(baseConfigDao.getEnv())
                .andIsDeletedEqualTo(false);
        List<TextBody> textBodies = textBodyMapper.selectByExample(textBodyExample);
        return CollectionUtils.isEmpty(textBodies) ? null : textBodies.get(0);
    }

    @Override
    public int addTextBody(TextBody textBody) {
        textBody.setEnv(baseConfigDao.getEnv());
        return textBodyMapper.insertSelective(textBody);
    }

    @Override
    public int updateTextBody(TextBody textBody) {
        return textBodyMapper.updateByPrimaryKeySelective(textBody);
    }
}
