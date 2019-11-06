package com.orange.jiang.nan.api.model.param;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xieyong
 * @date 2019/10/17
 * @Description: 分页查询的基本参数
 */
@Data
public class PageQueryParam implements Serializable {

    private static final long serialVersionUID = 4358915233690780725L;
    private Integer pageIndex = 1;
    private Integer pageSize = 10;
}
