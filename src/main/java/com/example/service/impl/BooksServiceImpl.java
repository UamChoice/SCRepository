package com.example.service.impl;

import java.util.List;

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

	@Autowired
	private BookMapper booksMapper;
	
	@Override
	public Book selectById(int id) {
		// TODO Auto-generated method stub
		return booksMapper.selectById(id);
	}

	@Override
	public List<Book> selectByTitle(String title) {
		// TODO Auto-generated method stub
		return booksMapper.selectByTitle(title);
	}

	@Override
	public List<Book> selectByTitlePrice(String title, double price) {
		// TODO Auto-generated method stub
		return booksMapper.selectByTitlePrice(title, price);
	}

	@Override
	public int insertBook(Book book) {
		// TODO Auto-generated method stub
		return booksMapper.insertBook(book);
	}

	@Override
	public int insertBookBatch(List<Book> bookList) {
		// TODO Auto-generated method stub
		return booksMapper.insertBookBatch(bookList);
	}

	@Override
	public int update(int id) {
		// TODO Auto-generated method stub
		return booksMapper.update(id);
	}

	@Override
	public int batchDelete(List<Integer> list) {
		// TODO Auto-generated method stub
		return booksMapper.batchDelete(list);
	}

}
