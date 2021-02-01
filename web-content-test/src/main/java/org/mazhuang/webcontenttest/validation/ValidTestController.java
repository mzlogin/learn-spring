package org.mazhuang.webcontenttest.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @Autowired
    private ValidTestService validTestService;

    @PostMapping("/valid/test")
    public String validTest(@RequestBody @Valid ValidTestParam param) {
        return "ok";
    }

    @GetMapping("/valid/testManualInvoke")
    public String validTestManualInvoke() {
        ValidTestParam.ParamProperties param = new ValidTestParam.ParamProperties();
        // 这样调用无效，@Valid 不会起作用
        manualInvokeTest(param);
        // 这样调用也无效，@Valid 不会起作用
        validTestService.manualInvokeTest(param);

        return "ok";
    }

    private void manualInvokeTest(@Valid ValidTestParam.ParamProperties param) {

    }
}
