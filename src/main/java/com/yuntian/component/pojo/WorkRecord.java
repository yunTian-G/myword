package com.yuntian.component.pojo;

import lombok.Data;

@Data
public class WorkRecord {

    public Long id;

    public String workName;

    public String details;

    public Integer status;

    public Long userId;

    public Integer reworkCount;

}
