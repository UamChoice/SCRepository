package com.example.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.Book;
import com.example.mapper.BookMapper;
import com.example.service.BookService;

/**   
* @Description： TODO
* @author： XL_FUTURE   
* @date： 2019年6月15日 下午10:27:26 
*/
@Service
public class BooksServiceImpl implements BookService {
	private static final Logger logger = LoggerFactory.getLogger(BooksServiceImpl.class);

	@Autowired
	private BookMapper bookMapper;
	
	@Override
	public Book selectById(int id) {
		// TODO Auto-generated method stub
		logger.info("GoInto serviceImpl selectByid");
		return bookMapper.selectById(id);
	}

	@Override
	public List<Book> selectByTitle(String title) {
		// TODO Auto-generated method stub
		return bookMapper.selectByTitle(title);
	}

	@Override
	public List<Book> selectByTitlePrice(String title, double price) {
		// TODO Auto-generated method stub
		return bookMapper.selectByTitlePrice(title, price);
	}

	@Override
	public int insertBook(Book book) {
		// TODO Auto-generated method stub
		return bookMapper.insertBook(book);
	}

	@Override
	public int insertBookBatch(List<Book> bookList) {
		// TODO Auto-generated method stub
		return bookMapper.insertBookBatch(bookList);
	}

	@Override
	public int update(int id) {
		// TODO Auto-generated method stub
		return bookMapper.update(id);
	}

	@Override
	public int batchDelete(List<Integer> list) {
		// TODO Auto-generated method stub
		return bookMapper.batchDelete(list);
	}

}
