package com.aub.pointOfSale.category;

import com.aub.pointOfSale.category.DTOs.CategoryDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity(name = "Category")
@RequiredArgsConstructor
@Data
@AllArgsConstructor
public class CategoryEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	public CategoryEntity(CategoryDto categoryDto){
		this.name = categoryDto.getName();
		this.description = categoryDto.getDescription();
	}
}
