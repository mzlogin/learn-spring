package org.mazhuang.webcontenttest.mapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mzlogin
 *
 * 类上的这个 RequestMapping 这种写法……其实是有问题的，IDE 会提示，但是它可以达到 /*\/test 一样的效果
 */
@RestController
@RequestMapping("/{abc}")
public class MappingTest2Controller {
    @GetMapping("/test")
    public String test() {
        return "ok";
    }
}
