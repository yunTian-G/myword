package com.yuntian.component.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class BaseEntity<T> {

    private Date createDate;
    private Date updateDate;
    private Long createOp;
    private Long updateOp;

}
