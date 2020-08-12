package com.spring.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: TODO
 * @Author: Super
 * @CreateDate: 2020/6/24 17:36
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
	private static final long serialVersionUID = 2687783510576030075L;

	private Integer id;
    private String userName;
    private String passWord;
    private Integer age;
    private String sex;
    private String phone;
}
