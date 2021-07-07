package com.capgi.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgi.demo.exception.ProductNotFoundException;

@RestController
@RequestMapping(value = "/product/api/v1")
public class ProductController {

	@GetMapping("/getproduct")
	public String getProduct() {
		//return "product found";
		throw new ProductNotFoundException();
	}
}
