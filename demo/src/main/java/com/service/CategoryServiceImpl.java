package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Category;
import com.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<String> findTitle(String categoryName) {
		List<String> titles = new ArrayList<>();
		for (int i = 0; i < categoryName.length(); i++) {
			for (int j = i; j < categoryName.length(); j++) {
				StringBuilder sb = new StringBuilder();
				sb.append(String.valueOf(categoryName.charAt(j)));
				List<String> list = (categoryRepository.findByCategoryName(sb.toString()));
				list.forEach(s -> titles.add(s));
			}
		}

		return titles;
	}

	@Override
	public Category addCategory(Category ctegory) {
		return categoryRepository.save(ctegory);
	}

	@Override
	public Category findCategoryId(Integer categoryId) {
		Optional<Category> opt = categoryRepository.findById(categoryId);
		return opt.get();
	}

}
