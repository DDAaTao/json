package com.xxs.json.mapper.my;

import com.xxs.json.entity.vo.TextLabelVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author van
 */
@Mapper
public interface MyLabelMapper {
    /**
     * 通过userId获取其对应的label
     * @param userId userId
     * @return labels
     * */
    List<TextLabelVO> getTextLabelsByUser(Long userId);
}
