package com.wang.exception.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created by HP on 2018/7/31.
 */
@Entity
@Data
/**
 * fasterxml.jackson 将对象转换为json报错处理
 */
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Girl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "这个字段必传")
    private String cupSize;

    @NotNull(message = "金额必传")
    private Double money;

    @Min(value = 18, message = "年龄必须大于18岁")
    private Integer age;
}



