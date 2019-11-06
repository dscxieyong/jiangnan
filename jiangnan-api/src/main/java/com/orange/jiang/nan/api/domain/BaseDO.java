package com.orange.jiang.nan.api.domain;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

/**
 * @author xieyong
 * @date 2019/11/05
 */
@Data
public class BaseDO implements Serializable {
    private static final long serialVersionUID = 7300922355700424170L;

    @Column(insertable = false)
    /**创建时间*/
    protected Date dateCreate;

    @Column(insertable = false)
    /**修改时间*/
    protected Date dateUpdate;
    /**删除时间*/
    protected Date dateDelete;

}
