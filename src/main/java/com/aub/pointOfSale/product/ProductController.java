package com.aub.pointOfSale.product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
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
			return new ResponseEntity<>(productService.updateProduct(productDto, id), HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

}
