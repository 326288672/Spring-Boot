package com.wang.exception.controller;
import com.wang.exception.Util.ResultUtil;
import com.wang.exception.domain.Girl;
import com.wang.exception.domain.ResponseVO;
import com.wang.exception.interfaces.GirlRepository;
import com.wang.exception.service.GirlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class GirlController {
    /**
     * getLogger方法中的参数与类名对应
     */
    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);
    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 1. 无需校验实例演示
     * @param girl
     * @return
     */
    @PostMapping(value = "/girls01")
    public Object girlAdd01(Girl girl) {
        int a=1/0;
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        return girlRepository.save(girl);
    }

    /**
     * 2.返回校验成功信息或校验失败信息
     * @param girl
     * @param bindingResult
     * @return
     */
    @PostMapping(value = "/girls02")
    public Object girlAdd02(@Valid Girl girl, BindingResult bindingResult) {
        //进行数据校验，及拦截
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            //打印在网页上
            return bindingResult.getFieldError().getDefaultMessage();
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        return girlRepository.save(girl);
    }

    /**
     * 3.返回校验成功信息或校验失败信息，打印在前端页面
     * @param girl
     * @param bindingResult
     * @return
     */
    @PostMapping(value = "/girls03")
    /* @Valid数据校验必须添加到方法参数上面*/
    public ResponseVO<Girl> girlAdd03(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            //封装对象数据
            ResponseVO result = new ResponseVO();
            result.setCode(1);
            result.setMsg(bindingResult.getFieldError().getDefaultMessage());
            //返回的数据对象是null
            result.setData(null);
            return result;
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        ResponseVO result = new ResponseVO();
        result.setCode(0);
        result.setMsg("成功");
        //校验成功返回数据
        result.setData(girlRepository.save(girl));
        return result;
    }

    /**
     * 4.重复代码需要优化，将相同代码抽取到一个工具类管理
     * @param girl
     * @param bindingResult
     * @return
     */
    @PostMapping(value = "/girls04")
    public ResponseVO<Girl> girlAdd04(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        return ResultUtil.success(girlRepository.save(girl));
    }

    /**
     * 通过id查询一个对象的年龄，并判断大小，返回不同结果
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/girls/getAge/{id}")
    public ResponseVO getGirlById(@PathVariable("id") Integer id) throws Exception{
        return ResultUtil.success(girlService.getAge(id));
    }
}

