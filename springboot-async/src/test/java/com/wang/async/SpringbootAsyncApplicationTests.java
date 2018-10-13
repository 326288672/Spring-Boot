package com.wang.async;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootAsyncApplicationTests {
    @Autowired
    AsyncTask asyncTask;
    @Test
    public void test()throws Exception {
        long start=System.currentTimeMillis();
        Future<Boolean> f1=asyncTask.doTask01();
        Future<Boolean> f2=asyncTask.doTask02();
        Future<Boolean> f3=asyncTask.doTask03();

        //执行此段代码也需要耗时间
        while(!f1.isDone()||!f2.isDone()||!f3.isDone()) {
            if(f1.isDone() && f2.isDone() && f3.isDone())
                break;
        }
        long end=System.currentTimeMillis();
        System.out.println("执行以上三个任务总耗时："+(end - start)+"毫秒");
    }

}
