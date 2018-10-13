package com.wang.mybatis.model.query;

import java.sql.Timestamp;

/**
 * Description: TbPersonQuery
 * Author: curd generator
 * Create: 2016-02-18 11:06
 */
public class TbPersonQuery {
	private Integer id;
	private String name;
	private Integer age;
	private Long offset;
	private Integer limit;

	public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

	public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

	public Integer getAge(){
        return this.age;
    }

    public void setAge(Integer age){
        this.age = age;
    }

	public Long getOffset(){
        return this.offset;
    }

    public void setOffset(Long offset){
        this.offset = offset;
    }

	public Integer getLimit(){
        return this.limit;
    }

    public void setLimit(Integer limit){
        this.limit = limit;
    }

}