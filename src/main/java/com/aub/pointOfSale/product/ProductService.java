package com.aub.pointOfSale.product;

import com.aub.pointOfSale.product.DTOs.DecrementProductDto;
import com.aub.pointOfSale.product.DTOs.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService
{
	List<ProductEntity> getAllProducts();

	ResponseEntity<?> addProduct(ProductDto productDto);

	ResponseEntity<?> updateProduct(ProductDto productDto, Long id);

	ResponseEntity<?> decrementProduct(DecrementProductDto decrementProductDto);

	ResponseEntity<?> deleteProduct(Long id);

	ResponseEntity<?> getProductById(Long id);
}
