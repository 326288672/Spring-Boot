package com.wang.mybatis;

import com.wang.mybatis.dao.TbPersonDao;
import com.wang.mybatis.model.po.TbPersonPO;
import com.wang.mybatis.model.query.TbPersonQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisApplicationTests {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    TbPersonDao tbPersonDao;

    @Autowired
    DataSource dataSource;
    TbPersonPO tbPersonPO=new TbPersonPO();
    TbPersonQuery tbPersonQuery=new TbPersonQuery();
    /* 测试数据源的类型*/
    @Test
    public void dataSource() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection=dataSource.getConnection();
        connection.close();
    }


    /* 1. 添加数据*/
    @Test
    public void insert() {
        tbPersonPO.setAge(23);
        tbPersonPO.setName("曹操");
        tbPersonDao.insert(tbPersonPO);
        logger.info("数据添加成功！");
    }
    /* 2. 修改数据*/
    @Test
    public void update() {
        tbPersonPO.setId(6); /* 指定具体要修改对象的id*/
        tbPersonPO.setAge(22);
        tbPersonPO.setName("刘华");
        tbPersonDao.update(tbPersonPO);
        logger.info("数据修改成功！");
    }
    /* 3.查询数据*/
    @Test
    public void query(){
        /* 起始位置*/
        tbPersonQuery.setOffset(1L);
        /* 限制查询条数用于分页使用*/
        tbPersonQuery.setLimit(3);
        List<TbPersonPO> list=tbPersonDao.query(tbPersonQuery);
       for(TbPersonPO tbPersonPO:list){
           System.out.println(tbPersonPO);
       }
    }
    /* 4. 删除数据*/
    @Test
    public void delete(){
        tbPersonPO.setId(8);
        int data=tbPersonDao.delete(tbPersonPO);
        if(data>0){
            System.out.println("数据删除成功");
        }
    }

    /* 4.统计数据*/
    @Test
    public void count(){
        long count=tbPersonDao.count(tbPersonQuery);
        System.out.println(count);
    }

    /* 5. 批量操作*/
    @Test
    public void batchInsert(){
        List<TbPersonPO> list=new ArrayList();
        TbPersonPO tbPersonPO1=new TbPersonPO();
        tbPersonPO1.setName("王杰");
        tbPersonPO1.setAge(16);
        list.add(tbPersonPO1);

        TbPersonPO tbPersonPO2=new TbPersonPO();
        tbPersonPO2.setName("张杰伦");
        tbPersonPO2.setAge(36);
        list.add(tbPersonPO2);

        tbPersonDao.batchInsert(list);
    }

}
