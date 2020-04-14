package org.mazhuang.webcontenttest;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

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

    /**
     * 1。 propertiesList 可以为 null
     * 2. propertiesList 可以为 empty
     * 3. 否则 propertiesList 里的元素的属性值会被校验
     */
    @Nullable
    @Valid
    private List<ParamProperties> propertiesList;

    @Data
    public static class ParamProperties {
        @NotBlank(message = "height 不能为空")
        private String height;

        @NotBlank(message = "weight 不能为空")
        private String weight;
    }
}
