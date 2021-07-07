package com.capgi.demo.service;

import java.util.List;

import com.capgi.demo.entity.Book;

public interface BookService {
   public List<Book> createBook(Book book);
   public Book getBookById(Integer id);
   public List<Book> editBook(Book book);
   public List<Book> deleteBook(Integer id);
   public List<Book> getAllBook();
   
   public List<Book> getBooksByName(String name);
   public List<Book> getBooksByPartialName(String name);
   public List<Book> getBooksByPriceLimit(int minPrice, int maxPrice);
}
