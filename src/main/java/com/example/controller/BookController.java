package com.example.controller;
/**   
* @Description： TODO
* @author： XL_FUTURE   
* @date： 2019年6月15日 下午11:05:15 
*/

import com.example.annotation.LoginAnno;
import com.example.dto.Book;
import com.example.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
		logger.info("GoInto BookController selectById");
		return bookService.selectById(id);
	}

	public List<Book> selectByTitle(String title) {
		Assert.isNull(title,"Book的title的不能为空");
		return bookService.selectByTitle(title);
	}

	public List<Book> selectByTitlePrice(String title, double price) {
		Assert.hasLength(title,"Book的title需要长度");
		return bookService.selectByTitlePrice(title, price);
	}

	public int insertBook(Book book) {
		return bookService.insertBook(book);
	}

	public int insertBookBatch(List<Book> bookList) {
		return bookService.insertBookBatch(bookList);
	}

	public int update(int id) {
		return bookService.update(id);
	}

	public int batchDelete(List<Integer> list) {
		return bookService.batchDelete(list);
	}
}
