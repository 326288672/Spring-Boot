package com.wang.exception.service;

import com.wang.exception.Enum.ResultEnum;
import com.wang.exception.Exception.GirlException;
import com.wang.exception.domain.Girl;
import com.wang.exception.interfaces.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    public Girl getAge(Integer id)throws Exception{
        Girl girl=girlRepository.getOne(id);
        Integer age=girl.getAge();

        if (age<10){
            //返回“你可能在上小学” code=100
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age>10 && age<16){
            //返回“你可能在上初中” code=101
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
        return girl;
    }
}
