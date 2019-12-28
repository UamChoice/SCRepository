package com.example.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**   
* @Description： 一个实体类，用于测试接收对象参数
* @author： XL_FUTURE   
* @date： 2019年5月10日 上午1:35:27 
*/

@ApiModel
public class User {
	
	@ApiModelProperty(example="小王")
	private String name;
	
	@ApiModelProperty(allowableValues="range[1,55]")
	private int age;
	
	//如果有带参构造函数，必须要有无参构造
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
}
