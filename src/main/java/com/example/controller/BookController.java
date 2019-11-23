package com.example.controller;
/**   
* @Description： TODO
* @author： XL_FUTURE   
* @date： 2019年6月15日 下午11:05:15 
*/

import java.util.List;

import com.example.annotation.LoginAnno;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.Book;
import com.example.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);

	@Autowired
	public BookService bookService;
	
	@RequestMapping("/selectById/{id}")
	@LoginAnno(name="登陆拦截器",values = {"hello","world"})
	//http://localhost:8889/book/selectById/14
	public Book selectById(@PathVariable("id") int id) {
		// TODO Auto-generated method stub
		logger.info("GoInto BookController selectById");
		return bookService.selectById(id);
	}

	public List<Book> selectByTitle(String title) {
		// TODO Auto-generated method stub
		return bookService.selectByTitle(title);
	}

	public List<Book> selectByTitlePrice(String title, double price) {
		// TODO Auto-generated method stub
		return bookService.selectByTitlePrice(title, price);
	}

	public int insertBook(Book book) {
		// TODO Auto-generated method stub
		return bookService.insertBook(book);
	}

	public int insertBookBatch(List<Book> bookList) {
		// TODO Auto-generated method stub
		return bookService.insertBookBatch(bookList);
	}

	public int update(int id) {
		// TODO Auto-generated method stub
		return bookService.update(id);
	}

	public int batchDelete(List<Integer> list) {
		// TODO Auto-generated method stub
		return bookService.batchDelete(list);
	}
}
