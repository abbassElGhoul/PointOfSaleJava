package com.aub.pointOfSale.category;

import com.aub.pointOfSale.category.DTOs.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService
{
	private final CategoryRepository categoryRepository;

	@Override
	public List<CategoryEntity> getAllCategories()
	{
		return categoryRepository.findAll();
	}

	@Override
	public ResponseEntity<?> addCategory(CategoryDto categoryDto) {
		try{
			return new ResponseEntity<>(categoryRepository.save(new CategoryEntity(categoryDto)), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<?> updateCategory(CategoryDto categoryDto, Long id) {
		try{
			CategoryEntity category = categoryRepository.findOnById(id);
			if(category == null){
				return new ResponseEntity<>("category not found", HttpStatus.BAD_REQUEST);
			}
			else {
				CategoryEntity categoryEntity = new CategoryEntity(categoryDto);
				categoryEntity.setId(category.getId());
				categoryRepository.save(categoryEntity);
				return new ResponseEntity<>(categoryEntity, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<?> getCategoryById(Long id) {
		try{
			CategoryEntity category = categoryRepository.findOnById(id);
			if(category == null){
				return new ResponseEntity<>("Category not found", HttpStatus.BAD_REQUEST);
			}
			else{
				return new ResponseEntity<>(category, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<?> deleteCategory(Long id) {
		try{
			CategoryEntity category = categoryRepository.findOnById(id);
			if(category == null){
				return new ResponseEntity<>("category not found", HttpStatus.BAD_REQUEST);
			}
			else {
				categoryRepository.deleteById(id);
				return new ResponseEntity<>("product deleted", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}
