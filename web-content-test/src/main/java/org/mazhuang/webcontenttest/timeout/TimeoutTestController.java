package org.mazhuang.webcontenttest.timeout;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuang.ma
 */
@RestController
@RequestMapping("/timeoutTest")
public class TimeoutTestController {

    @GetMapping("/ms")
    public String ms(@RequestParam int timeInMillis) throws InterruptedException {
        Thread.sleep(timeInMillis);
        return "ok";
    }

}
