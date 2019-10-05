package com.xxs.json.entity.vo;

import lombok.*;

/**
 * @author van
 */
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LabelChangeVO {
    private Long childrenId;
    private Long fatherId;
}
