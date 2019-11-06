package com.orange.jiang.nan.api.model.dto;

import com.alibaba.excel.annotation.ExcelIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xieyong
 * @date 2019/10/18
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseDTO implements Serializable {
    @ExcelIgnore
    private static final long serialVersionUID = -4175149559217021534L;
    /**
     *创建时间
     */
    @ExcelIgnore
    protected Date dateCreate;
    /**
     *修改时间
     */
    @ExcelIgnore
    protected Date dateUpdate;
    /**
     *删除时间
     */
    @ExcelIgnore
    protected Date dateDelete;
}
