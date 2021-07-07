package com.capgi.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value = HttpStatus.BAD_GATEWAY, reason = "Bookid Is Missing....")
public class ProductNotFoundException extends RuntimeException {

}
