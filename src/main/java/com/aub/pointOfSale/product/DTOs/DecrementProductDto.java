package com.aub.pointOfSale.product.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecrementProductDto
{
	private Long id;
	private int amount;
}
