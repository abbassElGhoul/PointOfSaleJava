package com.aub.pointOfSale.category;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/category")
@RequiredArgsConstructor
public class CategoryController
{
	private final CategoryService categoryService;

	@GetMapping("get-all")
	private List<CategoryEntity> getAllCategories(){
		return categoryService.getAllCategories();
	}


}
