package com.aub.pointOfSale.invoice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenerateReceiptDTO
{
	  private List<ProductAndQuantity> productAndQuantityList;
}
