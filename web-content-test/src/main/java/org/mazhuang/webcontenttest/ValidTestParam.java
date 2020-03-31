package org.mazhuang.webcontenttest;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * author: mazhuang
 * date: 2020/3/31
 */
@Data
public class ValidTestParam {
    @NotBlank(message = "name 不能为空")
    private String name;

    /**
     * 1. properties 可以为 null
     * 2. properties 不为 null 的话，它的属性值会被校验
     */
    @Valid
    private ParamProperties properties;

    @Data
    public static class ParamProperties {
        @NotBlank(message = "height 不能为空")
        private String height;

        @NotBlank(message = "weight 不能为空")
        private String weight;
    }
}
