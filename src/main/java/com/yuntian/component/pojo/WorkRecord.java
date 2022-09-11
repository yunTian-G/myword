package com.yuntian.component.pojo;

import lombok.Data;

@Data
public class WorkRecord extends BaseEntity<WorkRecord> {

    public Long id;

    public String workName;

    public String details;

    //1 新建 2 处理中 3 已处理 4 已确认 5 重新处理 6 已删除
    public Integer status;

    public Long userId;

    public Integer reworkCount;

}
