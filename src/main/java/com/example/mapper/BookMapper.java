package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.dto.Book;

/**   
* @Description： 通过Service调用的，一个走标准MVC的
* @author： XL_FUTURE   
* @date： 2019年6月10日 下午10:47:17 
*/
@Mapper
public interface BookMapper {
	Book selectById(int id);
	List<Book> selectByTitle(String title);
	List<Book> selectByTitlePrice(@Param("book_title") String title,@Param("book_price") double price);
	int insertBook(Book book);
	int insertBookBatch(@Param("booksListList") List<Book> bookList);
	
	int update(int id);
	int batchDelete(@Param("booksDelList") List<Integer> list);
}
