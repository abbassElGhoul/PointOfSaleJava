package com.aub.pointOfSale.invoice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductAndQuantity
{
	private Long productId;
	private int quantity;
}
