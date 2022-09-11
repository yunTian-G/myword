package com.yuntian.controller;

import com.mysql.cj.util.StringUtils;
import com.yuntian.component.pojo.WorkRecord;
import com.yuntian.component.util.Results;
import com.yuntian.component.util.SnowFlakeUtil;
import com.yuntian.service.RecordlistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@Slf4j
public class RecordlistController {

    @Autowired
    private RecordlistService service;

    @RequestMapping("/record/list/type/{type}")
    public Results<WorkRecord> getrecordlistByType(@PathVariable("type") String type){

        if(Integer.parseInt(type)>6 || Integer.parseInt(type)<1){
            return Results.failed(1,"非法状态值："+type);
        }

        return Results.successForRequest(0,"请求成功！",service.getRecordList());
    }

    @RequestMapping("/record/add")
    public Results addrecordlist(@RequestBody WorkRecord workRecord){

        log.debug("workRecord = {}",workRecord);
        System.out.println(workRecord.getDetails());
        workRecord.setId(SnowFlakeUtil.getSnowFlakeId());
//        workRecord.setWorkName("测试任务");
//        workRecord.setDetails("任务详细");
        workRecord.setUserId(2890477021L);//默认账号
        workRecord.setStatus(1);
        workRecord.setReworkCount(0);
        workRecord.setCreateDate(new Date());
        workRecord.setCreateOp(2890477021L);
        workRecord.setUpdateDate(new Date());
        workRecord.setUpdateOp(2890477021L);

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

        return Results.success(code,null);
    }

    @RequestMapping("/record/upd")
    public Results updStatus(@RequestParam("id") String id, @RequestParam("status")String status){

        if(StringUtils.isNullOrEmpty(id)){
            return Results.failed(1,"id不能为空！");
        }
        if(StringUtils.isNullOrEmpty(status)){
            return Results.failed(1,"状态不能为空！");
        }



        return null;
    }

}
