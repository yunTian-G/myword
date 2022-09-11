package com.yuntian.component.util;

import com.mysql.cj.util.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Results<T> {

    private Long resultcode;//0-成功 1-失败
    private String resultMessage;
    private T data;

    protected Results(long code,String resultMessage){
        this.resultcode = code;
        this.resultMessage = resultMessage;
    }

    public static <T> Results successForRequest(long code,String message,T data){
        return new Results(code,message,data);
    }

    public static <T> Results success(long code,String message){
        if(StringUtils.isNullOrEmpty(message)){
            if (code == 0){
                message = "请求成功！";
            }else{
                message = "请求失败！";
            }
        }
        return new Results(code,message);
    }

    public static Results failed(long code,String message){
        return new Results(code,message);
    }

}
