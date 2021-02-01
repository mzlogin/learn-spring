package org.mazhuang.webcontenttest.validation;

import org.springframework.stereotype.Service;

import javax.validation.Valid;

/**
 * @author mazhuang
 */
@Service
public class ValidTestServiceImpl implements ValidTestService {
    @Override
    public void manualInvokeTest(@Valid ValidTestParam.ParamProperties param) {

    }
}
