package org.mazhuang.webcontenttest.validation;

import javax.validation.Valid;

/**
 * @author mazhuang
 */
public interface ValidTestService {
    /**
     * 手动调用验证
     * @param param -
     */
    void manualInvokeTest(@Valid ValidTestParam.ParamProperties param);
}
