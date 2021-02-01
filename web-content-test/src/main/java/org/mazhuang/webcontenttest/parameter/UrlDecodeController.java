package org.mazhuang.webcontenttest.parameter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class UrlDecodeController {

    private static final String PARAM_MSG = "msg";

    /**
     * 测试参数是否会被 URLDecode
     *
     * 入参示例：urlencode('1+1=2')，即 '1%2B1%3D2'
     *
     * @param msg - （实际拿到的会是 UrlDecode 后的）
     * @param request -
     * @return -
     * @throws UnsupportedEncodingException -
     */
    @GetMapping("/param")
    public String getParam1(@Valid @NotEmpty @RequestParam(name = PARAM_MSG) String msg, HttpServletRequest request) throws UnsupportedEncodingException {
        // 这种写法会被 UrlDecode
        String msgFromParameter = request.getParameter(PARAM_MSG);

        // 这种写法获取到的是原始参数，不会被 UrlDecode
        String msgFromQueryString = getQueryParameter(request.getQueryString(), PARAM_MSG);

        log.info("msgFromParameter.equals(URLDecoder.decode(msgFromQueryString, \"utf-8\") result: {}", msgFromParameter.equals(URLDecoder.decode(msgFromQueryString, "utf-8")));

        StringBuilder result = new StringBuilder()
                .append("msg from @RequestParam: <br>")
                .append(msg)
                .append("<br><br> msg from request.getParameter: <br>")
                .append(msgFromParameter)
                .append("<br><br> msg from request.getQueryString: <br>")
                .append(msgFromQueryString)
                .append("<br><br> urldecode(msg from @RequestParam): <br>")
                .append(URLDecoder.decode(msg, "UTF-8"))
                .append("<br><br> urldecode(msg from request.getParameter): <br>")
                .append(URLDecoder.decode(msgFromParameter, "UTF-8"))
                .append("<br><br> urldecode(msg from request.getQueryString): <br>")
                .append(URLDecoder.decode(msgFromQueryString, "UTF-8"));

        return result.toString();
    }

    private String getQueryParameter(String queryString, String paramName) {
        String[] pairs = queryString.split("&");
        Map<String, String> params = Arrays.stream(pairs).map(v -> {
            String[] pair = v.split("=");
            String key = pair[0];
            String value = pair.length > 1 ? pair[1] : "";
            return new AbstractMap.SimpleEntry<>(key, value);
        }).collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue));
        return params.get(paramName);
    }
}
