package org.mazhuang.jacksontest.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * author: mazhuang
 * date: 2020/2/26
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClassAnnotationData {
    private Integer id;
    private String name;
    private Double score;
}
