package com.orange.jiang.nan.common.constants;

import lombok.Getter;

/**
 * @author xieyong
 * @date 2019/11/5
 * @Description:
 */
public enum BizErrorMsg {

    UNKNOWN_EXCEPTION(990,"未知异常"),
    NOT_EXIST_EXCEPTION(991,"服务不存在异常");

    @Getter
    private String errMsg;
    @Getter
    private Integer errCode;

    BizErrorMsg(Integer errCode, String errMsg){
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
}
