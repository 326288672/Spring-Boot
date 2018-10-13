package com.wang.mybatis.model.po;

import java.sql.Timestamp;

/**
 * Description: TbPersonPO
 * Author: curd generator
 * Create: 2016-02-18 11:06
 */
public class TbPersonPO {
	private Integer id;
	private String name;
	private Integer age;

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

    @Override
    public String toString() {
        return "TbPersonPO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}