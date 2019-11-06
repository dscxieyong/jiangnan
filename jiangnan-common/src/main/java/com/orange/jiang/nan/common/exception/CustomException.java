package com.orange.jiang.nan.common.exception;

import com.orange.jiang.nan.common.constants.BizErrorMsg;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @author xieyong
 * @date 2019/11/05
 * @descript: 自定义异常基类
 */
@Data
public class CustomException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -4483408950949466176L;

    /**
     * 异常对应的http码 默认 500
     */
    private Integer httpCode = HttpStatus.INTERNAL_SERVER_ERROR.value();

    /**
     * 错误码
     */
    private Integer errCode = BizErrorMsg.UNKNOWN_EXCEPTION.getErrCode();

    /**
     * 是否异常型错误，true-表示系统故障或数据出现异常 false-表示正常逻辑的失败分支
     */
    private boolean fault = true;

    public CustomException() {
        super();
    }

    public CustomException(BizErrorMsg bizErrorMsg) {
        super(bizErrorMsg.getErrMsg());
        this.errCode = bizErrorMsg.getErrCode();
    }

    public CustomException(Integer httpCode, BizErrorMsg bizErrorMsg, boolean fault) {
        super(bizErrorMsg.getErrMsg());
        this.httpCode = httpCode;
        this.errCode = bizErrorMsg.getErrCode();
        this.fault = fault;
    }

    public CustomException(BizErrorMsg bizErrorMsg, Throwable cause) {
        super(bizErrorMsg.getErrMsg(), cause);
        this.errCode = bizErrorMsg.getErrCode();
    }
}