package com.orange.jiang.nan.common.constants;

import lombok.Getter;

/**
 * @author xieyong
 * @date 2019/10/19
 * @Description: 异常类型枚举 用于打印日志
 */
public enum ErrorTypeEnum {
    STATUS_ERROR("状态异常"),
    PARAM_ERROR("参数异常"),
    BUSINESS_ERROR("业务异常"),
    DATABASE_ERROR("数据库异常");

    @Getter
    private String name;

    ErrorTypeEnum(String name) {
        this.name = name;
    }
}
