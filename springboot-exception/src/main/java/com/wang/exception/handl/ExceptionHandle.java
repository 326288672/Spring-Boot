package com.wang.exception.handl;

import com.wang.exception.Exception.GirlException;
import com.wang.exception.Util.ResultUtil;
import com.wang.exception.domain.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ControllerAdvice + @ExceptionHandler 组合进行的 Controller 层上抛出
 * 异常全局统一处理
 */
@ControllerAdvice
public class ExceptionHandle {

    //记录系统异常
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    /**
     * 1.@ExceptionHandler(GirlException.class) 声明了对 GirlException业务异常的处理，
     * 并获取该业务异常中的错误提示，构造后返回给客户端。
     *
     * 2.@ExceptionHandler(Exception.class) 声明了对 Exception 异常的处理，起到兜底作用，
     * 不管 Controller 层执行的代码出现了什么未能考虑到的异常，都返回统一的错误提示给客户端。
     */

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseVO handle(Exception e) {
        /* 判断异常对象*/
        if (e instanceof GirlException) {
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(), girlException.getMessage());
        } else {
            logger.error("【系统异常】 {}",e);
            return ResultUtil.error(-1, "未知错误");
        }
    }
}
