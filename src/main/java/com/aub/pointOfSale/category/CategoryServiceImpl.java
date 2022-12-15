package com.aub.pointOfSale.category;

import lombok.RequiredArgsConstructor;
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
}
