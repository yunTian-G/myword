package com.yuntian.service;

import com.yuntian.mapper.WorkRecordMapper;
import com.yuntian.component.pojo.WorkRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordlistService {

    @Autowired
    WorkRecordMapper workRecordMapper;

    public List<WorkRecord> getRecordList(){
        return workRecordMapper.getRecordList();
    }

    public Integer addRecordList(WorkRecord workRecord){
        return workRecordMapper.addRecord(workRecord);
    }
}
