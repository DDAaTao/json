package com.xxs.json.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TextBody implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column text_body.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column text_body.gmt_create
     *
     * @mbggenerated
     */
    private Date gmtCreate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column text_body.gmt_modified
     *
     * @mbggenerated
     */
    private Date gmtModified;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column text_body.user_id
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column text_body.label_name
     *
     * @mbggenerated
     */
    private String labelName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column text_body.is_deleted
     *
     * @mbggenerated
     */
    private Boolean isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column text_body.env
     *
     * @mbggenerated
     */
    private String env;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column text_body.text_body
     *
     * @mbggenerated
     */
    private String textBody;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table text_body
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column text_body.id
     *
     * @return the value of text_body.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column text_body.id
     *
     * @param id the value for text_body.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column text_body.gmt_create
     *
     * @return the value of text_body.gmt_create
     *
     * @mbggenerated
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column text_body.gmt_create
     *
     * @param gmtCreate the value for text_body.gmt_create
     *
     * @mbggenerated
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column text_body.gmt_modified
     *
     * @return the value of text_body.gmt_modified
     *
     * @mbggenerated
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column text_body.gmt_modified
     *
     * @param gmtModified the value for text_body.gmt_modified
     *
     * @mbggenerated
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column text_body.user_id
     *
     * @return the value of text_body.user_id
     *
     * @mbggenerated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column text_body.user_id
     *
     * @param userId the value for text_body.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column text_body.label_name
     *
     * @return the value of text_body.label_name
     *
     * @mbggenerated
     */
    public String getLabelName() {
        return labelName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column text_body.label_name
     *
     * @param labelName the value for text_body.label_name
     *
     * @mbggenerated
     */
    public void setLabelName(String labelName) {
        this.labelName = labelName == null ? null : labelName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column text_body.is_deleted
     *
     * @return the value of text_body.is_deleted
     *
     * @mbggenerated
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column text_body.is_deleted
     *
     * @param isDeleted the value for text_body.is_deleted
     *
     * @mbggenerated
     */
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column text_body.env
     *
     * @return the value of text_body.env
     *
     * @mbggenerated
     */
    public String getEnv() {
        return env;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column text_body.env
     *
     * @param env the value for text_body.env
     *
     * @mbggenerated
     */
    public void setEnv(String env) {
        this.env = env == null ? null : env.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column text_body.text_body
     *
     * @return the value of text_body.text_body
     *
     * @mbggenerated
     */
    public String getTextBody() {
        return textBody;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column text_body.text_body
     *
     * @param textBody the value for text_body.text_body
     *
     * @mbggenerated
     */
    public void setTextBody(String textBody) {
        this.textBody = textBody == null ? null : textBody.trim();
    }
}