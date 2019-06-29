package com.example.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

/**   
* @Description： Mysql books实体类
* 如果不开启驼峰mapUnderscoreToCamelCase，会输出：Book(id=2, bookTitle=null, bookPrice=0.0, publishDate=null)
* @author： XL_FUTURE   
* @date： 2019年5月26日 下午4:30:33 
*/
@Data
@NoArgsConstructor
public class Book {
	private int id;
	private String bookTitle;
	private double bookPrice;
	private Date publishDate;
}
