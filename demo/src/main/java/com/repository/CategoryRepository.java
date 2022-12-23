package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	public List<String> findByCategoryName(String categoryName);

}
