package org.mazhuang.jacksontest.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * author: mazhuang
 * date: 2020/2/26
 */
@Data
public class FieldAnnotationData {
    private Integer id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;
    private Double score;
}
