package com.aub.pointOfSale.product;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService
{
	List<ProductEntity> getAllProducts();

	ResponseEntity<?> addProduct(ProductDto productDto);

	ResponseEntity<?> updateProduct(ProductDto productDto, Long id);
}
