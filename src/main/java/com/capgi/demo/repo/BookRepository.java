package com.capgi.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgi.demo.entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer>{
    @Query(value = "select b from Book b where b.bookName=:name")
	public List<Book> getBooksByName(String name);
    
    @Query(value = "select * from Book b where b.bookName like %:name%" , nativeQuery = true)
    public List<Book> getBooksByPartialName(String name);
    
    @Query(value = "select b from Book b where b.bookPrice>=?1 and b.bookPrice<=?2")
	public List<Book> getBooksByPrice(Integer minPrice, Integer maxPrice);
    
    
    //followed by naming convention for query build
    public List<Book> findByBookNameContaining(String name);
    public List<Book> findByBookNameStartsWith(String name);
    public List<Book> findByBookNameEndsWith(String name);
    public List<Book> findByBookNameContainingIgnoreCase(String name);
    
    public List<Book> findByBookNameNotContaining(String name);
}
