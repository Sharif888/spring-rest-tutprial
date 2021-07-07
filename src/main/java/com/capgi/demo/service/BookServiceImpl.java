package com.capgi.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgi.demo.entity.Book;
import com.capgi.demo.exception.BookNotFoundException;
import com.capgi.demo.repo.BookRepository;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookRepository bookRepository;
	
	@Override
	@Transactional
	public List<Book> createBook(Book book) {
		bookRepository.save(book);
		List<Book> list = (List<Book>) bookRepository.findAll();
		return list;
	}

	@Override
	@Transactional
	public Book getBookById(Integer id) {
		Optional<Book> book = bookRepository.findById(id);
		if(book.isPresent())
		    return book.get();
		else
			throw new BookNotFoundException();
	}

	@Override
	@Transactional
	public List<Book> editBook(Book book) {
		Book b = getBookById(book.getBookId());
		if(b!=null)
		   bookRepository.save(book);
		
		List<Book> list = (List<Book>) bookRepository.findAll();
		return list;
	}
	
	@Override
	@Transactional
	public List<Book> deleteBook(Integer id) {
		Book b = getBookById(id);
		if(b!=null)
		   bookRepository.deleteById(id);
		
		List<Book> list = (List<Book>) bookRepository.findAll();
		return list;
	}
	
	@Override
	@Transactional
	public List<Book> getAllBook() {
		List<Book> list = (List<Book>) bookRepository.findAll();
		return list;
	}

	@Override
	@Transactional
	public List<Book> getBooksByName(String name) {
		List<Book> list = bookRepository.getBooksByName(name);
		return list;
	}
	
	@Override
	@Transactional
	public List<Book> getBooksByPriceLimit(int minPrice, int maxPrice) {
		List<Book> list = bookRepository.getBooksByPrice(minPrice, maxPrice);
		return list;
	}
	@Override
	@Transactional
	public List<Book> getBooksByPartialName(String name) {
		//List<Book> list = bookRepository.findByBookNameContaining(name);
		//List<Book> list = bookRepository.getBooksByPartialName(name);
		//List<Book> list = bookRepository.findByBookNameStartsWith(name);
		//List<Book> list =  bookRepository.findByBookNameEndsWith(name);
		//List<Book> list = bookRepository.findByBookNameNotContaining(name);
		List<Book> list = bookRepository.getBooksByPrice(2000, 4000);
		return list;
	}
}
