package org.mazhuang.webcontenttest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * author: mazhuang
 * date: 2020/3/31
 */
@RestController
public class ValidTestController {

    @PostMapping("/valid/test")
    public String validTest(@RequestBody @Valid ValidTestParam param) {
        return "ok";
    }
}
