package com.xxs.json.mapper;

import com.xxs.json.entity.TextLabel;
import com.xxs.json.entity.TextLabelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TextLabelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table text_label
     *
     * @mbggenerated
     */
    int countByExample(TextLabelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table text_label
     *
     * @mbggenerated
     */
    int deleteByExample(TextLabelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table text_label
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table text_label
     *
     * @mbggenerated
     */
    int insert(TextLabel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table text_label
     *
     * @mbggenerated
     */
    int insertSelective(TextLabel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table text_label
     *
     * @mbggenerated
     */
    List<TextLabel> selectByExampleWithBLOBs(TextLabelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table text_label
     *
     * @mbggenerated
     */
    List<TextLabel> selectByExample(TextLabelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table text_label
     *
     * @mbggenerated
     */
    TextLabel selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table text_label
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") TextLabel record, @Param("example") TextLabelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table text_label
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") TextLabel record, @Param("example") TextLabelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table text_label
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") TextLabel record, @Param("example") TextLabelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table text_label
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TextLabel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table text_label
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(TextLabel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table text_label
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TextLabel record);
}