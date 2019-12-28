package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dto.Book;

/**   
* @Description： TODO
* @author： XL_FUTURE   
* @date： 2013年1月2日 上午1:33:48 
*/

public interface BookService {
	Book selectById(int id);
	List<Book> selectByTitle(String title);
	List<Book> selectByTitlePrice(String title, double price);
	int insertBook(Book book);
	int insertBookBatch(List<Book> bookList);
	
	int update(int id);
	int batchDelete(List<Integer> list);
}
