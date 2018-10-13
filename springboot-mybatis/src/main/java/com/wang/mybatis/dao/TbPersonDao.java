package com.wang.mybatis.dao;

import com.wang.mybatis.model.po.TbPersonPO;
import com.wang.mybatis.model.query.TbPersonQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description: TbPersonDao
 * Author: curd generator
 * Create: 2016-02-18 11:45
 */
@Repository
public interface TbPersonDao {

    int insert(TbPersonPO po);

    int batchInsert(List<TbPersonPO> list);

    int update(TbPersonPO po);

    int delete(TbPersonPO po);

    List<TbPersonPO> query(TbPersonQuery query);

    long count(TbPersonQuery query);

}