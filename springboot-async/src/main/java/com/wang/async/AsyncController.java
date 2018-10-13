package com.wang.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@RestController
public class AsyncController {
    @Autowired
    AsyncTask asyncTask;
    @RequestMapping("/testAsycn")
    public String testAsync() throws Exception {
        long start = System.currentTimeMillis();
        Future<Boolean> f1 = asyncTask.doTask01();
        Future<Boolean> f2 = asyncTask.doTask02();
        Future<Boolean> f3 = asyncTask.doTask03();

        while (!f1.isDone() || !f2.isDone() || !f3.isDone()) {
            if (f1.isDone() && f2.isDone() && f3.isDone())
                break;
        }
        //记录方法执行后的时间
        long end = System.currentTimeMillis();
        String time="执行以上三个任务总耗时：" + (end - start) + "毫秒";
        return time;
    }
}


