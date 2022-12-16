package com.aub.pointOfSale.category;

import com.aub.pointOfSale.category.DTOs.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
@RequestMapping("api/category")
@RequiredArgsConstructor
public class CategoryController
{
	private final CategoryService categoryService;

	@GetMapping("get-all")
	private ResponseEntity<?> getAllCategories()
	{
		try
		{
			return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@GetMapping("get-category-by-id")
	private ResponseEntity<?> getCategoryById(@RequestParam Long id)
	{
		try
		{
			return new ResponseEntity<>(categoryService.getCategoryById(id), HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("add-category")
	private ResponseEntity<?> addCategory(@RequestBody CategoryDto categoryDto)
	{
		try
		{
			return categoryService.addCategory(categoryDto);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("update-category")
	private ResponseEntity<?> updateCategory(@RequestBody CategoryDto categoryDto, @RequestParam Long id)
	{
		try
		{
			return categoryService.updateCategory(categoryDto, id);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("delete-category")
	private ResponseEntity<?> deleteCategory(@RequestParam Long id)
	{
		try
		{
			return categoryService.deleteCategory(id);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
