package com.aub.pointOfSale.category;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService
{
	List<CategoryEntity> getAllCategories();
}
