package org.mazhuang.freemarker_test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/somepage")
    public String somepage() {
        return "somepage";
    }

}
