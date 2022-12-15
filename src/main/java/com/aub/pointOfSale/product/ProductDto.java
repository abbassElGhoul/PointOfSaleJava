package com.aub.pointOfSale.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto
{
	private String name;
	private Long categoryId;
	private String price;
	private String description;
	private Integer quantity;
}
