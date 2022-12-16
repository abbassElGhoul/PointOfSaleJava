package com.aub.pointOfSale.category;

import com.aub.pointOfSale.category.DTOs.CategoryDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService
{
	List<CategoryEntity> getAllCategories();

	ResponseEntity<?> addCategory(CategoryDto categoryDto);
	ResponseEntity<?> updateCategory(CategoryDto categoryDto, Long id);
	ResponseEntity<?> getCategoryById(Long id);
	ResponseEntity<?> deleteCategory(Long id);
}
