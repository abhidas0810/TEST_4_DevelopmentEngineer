package com.service;

import java.util.List;

import com.model.Category;

public interface CategoryService {

	public List<String> findTitle(String categoryName);

	public Category addCategory(Category ctegory);

	public Category findCategoryId(Integer categoryId);

}
