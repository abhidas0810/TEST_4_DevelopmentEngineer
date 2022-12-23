package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Category;
import com.service.CategoryService;

@RestController
public class Controller {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("title/{categoryName}")
	public ResponseEntity<List<String>> findTitleHandler(@PathVariable("categoryName") String categoryName) {
		return new ResponseEntity<List<String>>(categoryService.findTitle(categoryName), HttpStatus.OK);
	}

	@PostMapping("category")
	public ResponseEntity<Category> addCategoryHandler(@RequestBody Category ctegory) {
		return new ResponseEntity<Category>(categoryService.addCategory(ctegory), HttpStatus.ACCEPTED);
	}

	@GetMapping("category/{categoryId}")
	public ResponseEntity<Category> findCategoryIdHandler(@PathVariable("categoryId") Integer categoryId) {
		return new ResponseEntity<Category>(categoryService.findCategoryId(categoryId), HttpStatus.OK);
	}

}
