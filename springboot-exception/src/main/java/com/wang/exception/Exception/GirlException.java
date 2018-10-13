package com.wang.exception.Exception;

import com.wang.exception.Enum.ResultEnum;

/**
 * Created by HP on 2018/7/31.
 */
public class GirlException extends RuntimeException {
    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        //父类的构造方法本身会传message进去
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }
}
