package com.aub.pointOfSale.product;

import com.aub.pointOfSale.product.DTOs.DecrementProductDto;
import com.aub.pointOfSale.product.DTOs.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
@RequestMapping("api/product")
@RequiredArgsConstructor
public class ProductController
{

	private final ProductService productService;

	@GetMapping("get-all")
	private ResponseEntity<?> getAllProducts()
	{
		try
		{
			return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@GetMapping("get-product-by-id")
	private ResponseEntity<?> getProductById(@RequestParam Long id)
	{
		try
		{
			return productService.getProductById(id);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	@PostMapping("add-product")
	private ResponseEntity<?> addProduct(@RequestBody ProductDto productDto)
	{
		try
		{
			return productService.addProduct(productDto);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@PutMapping("update-product")
	private ResponseEntity<?> updateProduct(@RequestBody ProductDto productDto, @RequestParam Long id)
	{
		try
		{
			return productService.updateProduct(productDto, id);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@DeleteMapping("delete-product")
	private ResponseEntity<?> deleteProduct(@RequestParam Long id)
	{
		try
		{
			return productService.deleteProduct(id);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("decrement-product")
	private ResponseEntity<?> decrementProduct(@RequestBody DecrementProductDto decrementProductDto)
	{
		try
		{
			return productService.decrementProduct(decrementProductDto);
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}
}
