package com.wang.exception.Util;

import com.wang.exception.domain.ResponseVO;
/*编写一个工具类*/
public class ResultUtil {

    /* 1.返回成功显示的数据*/
    public static ResponseVO success(Object object) {
        ResponseVO result = new ResponseVO();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static ResponseVO success() {
        return success(null);
    }
    /* 1.返失败携带的数据*/
    public static ResponseVO error(Integer code, String msg) {
        ResponseVO result = new ResponseVO();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
