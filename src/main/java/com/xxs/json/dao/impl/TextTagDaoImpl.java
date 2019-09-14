package com.xxs.json.dao.impl;

import com.xxs.json.dao.BaseConfigDao;
import com.xxs.json.dao.TextTagDao;
import com.xxs.json.entity.TextTag;
import com.xxs.json.mapper.TextTagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author van
 */
@Service
public class TextTagDaoImpl implements TextTagDao {
    @Autowired
    private TextTagMapper mapper;

    @Autowired
    private BaseConfigDao baseConfigDao;

    @Override
    public void addTag(TextTag tag) {

    }
}
