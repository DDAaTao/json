package com.xxs.json.mapper;

import com.xxs.json.entity.TextTag;
import com.xxs.json.entity.TextTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TextTagMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table text_tag
     *
     * @mbggenerated
     */
    int countByExample(TextTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table text_tag
     *
     * @mbggenerated
     */
    int deleteByExample(TextTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table text_tag
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table text_tag
     *
     * @mbggenerated
     */
    int insert(TextTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table text_tag
     *
     * @mbggenerated
     */
    int insertSelective(TextTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table text_tag
     *
     * @mbggenerated
     */
    List<TextTag> selectByExample(TextTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table text_tag
     *
     * @mbggenerated
     */
    TextTag selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table text_tag
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") TextTag record, @Param("example") TextTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table text_tag
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") TextTag record, @Param("example") TextTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table text_tag
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TextTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table text_tag
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TextTag record);
}