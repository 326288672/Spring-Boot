package com.wang.exception.domain;

import lombok.Data;


@Data
/* 1.定义一个封装类，用于封装数据返回给前端*/
public class ResponseVO<T>  {
    /*错误码*/
    private Integer code;
    /*提示信息*/
    private String msg;
   /* 使用泛型封装数据*/
    private T data;
}
