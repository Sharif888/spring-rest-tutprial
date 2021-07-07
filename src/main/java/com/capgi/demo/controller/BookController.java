package com.capgi.demo.controller;

import java.util.List;

import javax.print.attribute.standard.Severity;
import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgi.demo.entity.Book;
import com.capgi.demo.service.BookService;

@RestController
@RequestMapping(value = "/book/api/v1")
@Validated
public class BookController {
    @Autowired
	BookService service;
    
    @DeleteMapping(value = "/deletebook/{id}")
    public ResponseEntity<List<Book>> deleteBookById(@PathVariable Integer id){
    	List<Book> list = service.deleteBook(id);
    	return new ResponseEntity<List<Book>>(list,HttpStatus.OK);
    }
    
    @PutMapping(value = "/editbook")
    public ResponseEntity<List<Book>> editBook(@Valid @RequestBody Book book){
    	List<Book> list = service.editBook(book);
    	return new ResponseEntity<List<Book>>(list,HttpStatus.OK);
    }
    @GetMapping(value = "/getbooksbyprice/{minPrice}/{maxPrice}")
    public ResponseEntity<List<Book>>getAllBooksByPriceLimit(@PathVariable int minPrice, @PathVariable int maxPrice){
    	List<Book> list = service.getBooksByPriceLimit(minPrice, maxPrice);
    	return new ResponseEntity<List<Book>>(list,HttpStatus.OK);
    }
    
    @GetMapping(value = "/getallbooks")
    public ResponseEntity<List<Book>> getAllBooks(){
    	List<Book> list = service.getAllBook();
    	return new ResponseEntity<List<Book>>(list,HttpStatus.OK);
    }
    @GetMapping(value = "/getbook/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable  @Min(100) Integer id) {
    	Book book = service.getBookById(id);
    	return new ResponseEntity<Book>(book, HttpStatus.OK);
    }
    
	@PostMapping(value = "/createbook")
    public ResponseEntity<List<Book>> createBook(@Valid @RequestBody Book book) {
		List<Book> list = service.createBook(book);
		return new ResponseEntity<List<Book>>(list,HttpStatus.OK);
    }
	
	
}
