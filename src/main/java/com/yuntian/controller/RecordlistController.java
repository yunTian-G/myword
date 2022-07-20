package com.yuntian.controller;

import com.yuntian.component.pojo.WorkRecord;
import com.yuntian.component.util.Results;
import com.yuntian.component.util.SnowFlakeUtil;
import com.yuntian.service.RecordlistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class RecordlistController {

    @Autowired
    private RecordlistService service;

    @RequestMapping("/record/list/type/{type}")
    public Results getrecordlistByType(@PathVariable("type") String type){

        if(Integer.parseInt(type)>6 || Integer.parseInt(type)<1){
            return Results.failed(1,"非法状态值："+type);
        }

        return Results.successForRequest(0,"请求成功！",service.getRecordList());
    }

    @RequestMapping("/record/add")
    public Object addrecordlist(@RequestBody WorkRecord workRecord){

        log.debug("workRecord = {}",workRecord);
        System.out.println(workRecord.getDetails());
        workRecord.setId(SnowFlakeUtil.getSnowFlakeId());
//        workRecord.setWorkName("测试任务");
//        workRecord.setDetails("任务详细");
        workRecord.setUserId(2890477021L);//默认账号
        workRecord.setStatus(1);
        workRecord.setReworkCount(0);

        if(workRecord.getWorkName() == null || workRecord.getWorkName() == ""){
            return Results.failed(1,"标题不能为空！");
        }

        if(workRecord.getDetails() == null || workRecord.getDetails() == ""){
            return Results.failed(1,"详情不能为空！");
        }

        var result = service.addRecordList(workRecord);
        var code = 1;
        if (result>0){
            code = 0;
        }

        return Results.success(code,"请求成功！");
    }

}
