package org.mazhuang.webcontenttest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * URL 映射测试
 *
 * @author mzlogin
 */
// 以下这种方式实现不了，attribute value must be constant, String[] 引用没办法是 constant
// 编译时常量表达式只能是原始类型或者 String 组合
// https://docs.oracle.com/javase/specs/jls/se7/html/jls-15.html#jls-15.28
//@RequestMapping(value = MappingTestController.sPrefixs)
@RestController
public class MappingTestController {
    public static final String[] sPrefixs = {"a", "b"};

    @GetMapping("/test")
    public String test() {
        return "ok";
    }

    @GetMapping("/*/test1")
    public String test1() {
        return "ok";
    }
}
