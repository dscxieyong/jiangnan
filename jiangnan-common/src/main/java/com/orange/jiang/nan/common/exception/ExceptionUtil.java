package com.orange.jiang.nan.common.exception;

import com.orange.jiang.nan.common.constants.BizErrorMsg;

/**
 * @author dingchenchen
 * @date 2019/10/25
 */
public class ExceptionUtil {


    /**
     * 错误码默认为500(此异常不会报警钉钉群
     * @param bizErrorMsg
     * @return
     * @throws CustomException
     */
    public static CustomException fail(BizErrorMsg bizErrorMsg) throws CustomException {
        CustomException exception = new CustomException(bizErrorMsg);
        exception.setFault(false);
        return exception;
    }
    /**
     * 错误码默认为500
     * @param bizErrorMsg
     * @return
     * @throws CustomException
     */
    public static CustomException fault(BizErrorMsg bizErrorMsg) throws CustomException {
        CustomException exception = new CustomException(bizErrorMsg);
        exception.setFault(true);
        return exception;
    }
}
