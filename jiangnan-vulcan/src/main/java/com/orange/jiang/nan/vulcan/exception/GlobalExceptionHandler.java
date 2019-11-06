package com.orange.jiang.nan.vulcan.exception;

import com.orange.jiang.nan.api.model.dto.Result;
import com.orange.jiang.nan.common.exception.CustomException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xieyong
 * @date 2019/11/05
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result<Object> handleException(Exception e) {

        if (e instanceof IllegalArgumentException) {
            Result res = genErrorInfo(500, "ILLEGAL_ARGUMENT", e.getMessage());
            log.error(e.getMessage(), e);
            return res;
        }
        //自定义异常
        if (e instanceof CustomException) {
            Result res = genErrorInfo(((CustomException) e).getHttpCode(), ((CustomException) e).getErrCode().toString(), e.getMessage());
            log.error(e.getMessage(), e);
            return res;
        }

        log.error("error",e);
        Result res = genErrorInfo(500, "INTERNAL_SERVER_ERROR", "系统异常");
        return res;
    }

    private Result genErrorInfo(int code, String errCode, String message) {
        if (errCode == null) {
            errCode = "SERVICE_EXCEPTION";
        }
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setErrCode(errCode);
        if (StringUtils.isBlank(message)) {
            message = "系统异常";
        }
        errorInfo.setMessage(message);
        Result res = new Result();
        res.setSuccess(false);
        res.setCode(code + "");
        res.setData(errorInfo);
        res.setMsg(message);
        return res;
    }

    @Data
    private static class ErrorInfo {
        private String errCode;
        private String message;
    }
}
