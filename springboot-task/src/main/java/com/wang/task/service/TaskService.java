package com.wang.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    //@Scheduled(cron = "0,1,2,3,4 * * * * MON-SAT")//表示前4秒都执行一次
    //@Scheduled(cron = "0-4 * * * * MON-SAT")//表示前4秒都执行一次
    @Scheduled(cron = "0/4 * * * * MON-SAT") //表示每隔4秒执行一次
    public void test01(){
        System.out.println("=====定时执行一些业务=====");
        System.out.println("01.定时向用户发送短信");
        System.out.println("02.定时删除缓存中的数据");
        System.out.println("03.定时数据库备份");
    }

    //每隔6秒执行一次
    @Scheduled(fixedRate = 6000)
    public void test02(){
        System.out.println("Hello World");
    }
}
