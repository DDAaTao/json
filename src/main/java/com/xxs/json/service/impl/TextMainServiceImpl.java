package com.xxs.json.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.xxs.json.common.BaseConstant;
import com.xxs.json.common.JsonGroupException;
import com.xxs.json.common.util.DateUtils;
import com.xxs.json.dao.TextBodyDao;
import com.xxs.json.dao.TextLabelDao;
import com.xxs.json.entity.TextBody;
import com.xxs.json.entity.TextLabel;
import com.xxs.json.entity.vo.TextLabelVO;
import com.xxs.json.mapper.my.MyLabelMapper;
import com.xxs.json.service.TextMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author van
 */
@Service
public class TextMainServiceImpl implements TextMainService {

    @Autowired
    private TextBodyDao textBodyDao;

    @Autowired
    private TextLabelDao textLabelDao;

    @Autowired
    private MyLabelMapper myLabelMapper;

    @Override
    public List<TextLabelVO> getTextLabelByUser(Long userId) {
        List<TextLabelVO> textLabelsByUser = myLabelMapper.getTextLabelsByUser(userId);
        if (CollectionUtils.isEmpty(textLabelsByUser)){
            return null;
        }
        List<TextLabelVO> labelVos = Lists.newArrayListWithCapacity(textLabelsByUser.size());
        Map<Long, TextLabelVO> voById = Maps.newHashMapWithExpectedSize(labelVos.size());
        Iterator<TextLabelVO> iterator = textLabelsByUser.iterator();
        // todo 可定义一个最大循环次数，防止异常情况导致无限循环
        while (textLabelsByUser.size() > 0){
            while (iterator.hasNext()){
                TextLabelVO textLabel = iterator.next();
                if (textLabel.getFatherId() == null){
                    labelVos.add(textLabel);
                    voById.put(textLabel.getId(), textLabel);
                    iterator.remove();
                }else if (voById.get(textLabel.getFatherId()) != null){
                    TextLabelVO vo = voById.get(textLabel.getId());
                    vo.getChildren().add(textLabel);
                    voById.put(textLabel.getId(), vo);
                    iterator.remove();
                }
            }
        }
        return labelVos;
    }

    @Override
    public List<TextLabelVO> getTextLabelByUserTwo(Long userId) {
        // 可不可以直接设计一个可以通过id获取对象的集合
        List<TextLabelVO> textLabelsByUser = myLabelMapper.getTextLabelsByUser(userId);
        if (CollectionUtils.isEmpty(textLabelsByUser)){
            return null;
        }
        // entry -> entry 还可以用 Function.identity() 代替
        Map<Long, TextLabelVO> voById = textLabelsByUser.stream().collect(Collectors.toMap(TextLabelVO::getId
                , entry -> entry, (key1, key2) -> key1, HashMap::new));
        List<TextLabelVO> resultList = Lists.newArrayListWithCapacity(textLabelsByUser.size() / 2);
        for (TextLabelVO vo : textLabelsByUser) {
            if (vo.getFatherId() == null){
                resultList.add(vo);
            }else {
                TextLabelVO father = voById.get(vo.getFatherId());
                if (CollectionUtils.isEmpty(father.getChildren())){
                    father.setChildren(Lists.newArrayList(vo));
                }else {
                    father.getChildren().add(vo);
                }
            }
        }
        return resultList;
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

    @Override
    public TextBody getTextBodyByTextId(Long textId) {
        return textBodyDao.getTextBodyByTextId(textId);
    }
}
