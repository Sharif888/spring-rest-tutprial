package com.capgi.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Book {
@Id
@Column(name="bookid")
@NotNull
@Min(value = 100)
private Integer bookId;
@Column(name="bookname")
@NotBlank
@Size(min = 6 , max = 15)
private String bookName;
@Column(name="bookprice")
@Min(value = 100)
private Integer bookPrice;
public Integer getBookId() {
	return bookId;
}
public void setBookId(Integer bookId) {
	this.bookId = bookId;
}
public String getBookName() {
	return bookName;
}
public void setBookName(String bookName) {
	this.bookName = bookName;
}
public Integer getBookPrice() {
	return bookPrice;
}
public void setBookPrice(Integer bookPrice) {
	this.bookPrice = bookPrice;
}

}
