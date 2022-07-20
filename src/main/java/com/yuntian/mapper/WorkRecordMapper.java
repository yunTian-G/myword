package com.yuntian.mapper;

import com.yuntian.component.pojo.WorkRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface WorkRecordMapper {

    //@Select("select * from workbook")
    List<WorkRecord> getRecordList();

    Integer addRecord(WorkRecord workRecord);

}
