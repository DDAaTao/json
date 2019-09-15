package com.xxs.json.entity.vo;

import lombok.*;

import java.util.List;

/**
 * @author van
 */
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TextLabelVO {
    private Long id;
    private String labelName;
    /**
     * 侧栏类型，1为文件夹，2为文本
     * */
    private Byte labelType;
    private List<TextLabelVO> child;
}
