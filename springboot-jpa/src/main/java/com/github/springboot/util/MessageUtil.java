package com.github.springboot.util;

import com.github.springboot.domain.Result;

public class MessageUtil {

    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("success");
        if (object!=null){
            result.setData(object);
        }
        return result;
    }
    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code, String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(message);
        return result;
    }
}
