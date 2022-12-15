package com.aub.pointOfSale.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity(name = "product")
@RequiredArgsConstructor
@Data
@AllArgsConstructor
//@NoArgsConstructor
public class ProductEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@Column(name = "name")
	private String name;
	@Column(name = "category_id")
	private Long categoryId;
	@Column(name = "price")
	private String price;
	@Column(name = "description")
	private String description;
	@Column(name = "quantity")
	private Integer quantity;

	public ProductEntity(ProductDto productDto)
	{
		this.name = productDto.getName();
		this.categoryId = productDto.getCategoryId();
		this.price = productDto.getPrice();
		this.description = productDto.getDescription();
		this.quantity = productDto.getQuantity();
	}
}
