package com.wang.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class AsyncTask {

    /**
     * 1.如果执行下面三个方法是同步任务耗时：1000+800+400
     * 2.开启异步任务执行下面三个方法耗时：取耗时最大的1000，
     *   也就是执行三个方法只需要1000
     */
    @Async
    public Future<Boolean> doTask01()throws Exception{
        long start=System.currentTimeMillis();
        //使用线程的目的测试方法执行时间
        Thread.sleep(1000);
        long end=System.currentTimeMillis();
        System.out.println("执行任务1耗时："+(end - start)+"毫秒");
        return new AsyncResult<>(true);
    }
    @Async
    public Future<Boolean> doTask02()throws Exception{
        long start=System.currentTimeMillis();
        Thread.sleep(700);
        long end=System.currentTimeMillis();
        System.out.println("执行任务2耗时："+(end - start)+"毫秒");
        return new AsyncResult<>(true);
    }
    @Async
    public Future<Boolean> doTask03()throws Exception{
        long start=System.currentTimeMillis();
        Thread.sleep(600);
        long end=System.currentTimeMillis();
        System.out.println("执行任务3耗时："+(end - start)+"毫秒");
        return new AsyncResult<>(true);
    }
}
