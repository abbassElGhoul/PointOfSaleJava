package com.aub.pointOfSale.product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService
{

	private final ProductRepository productRepository;

	@Override
	public List<ProductEntity> getAllProducts()
	{
		return productRepository.findAll();
	}

	@Override
	public ResponseEntity<?> addProduct(ProductDto productDto)
	{
		try
		{
			return new ResponseEntity<>(productRepository.save(new ProductEntity(productDto)), HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<?> updateProduct(ProductDto productDto, Long id)
	{
		try
		{
			ProductEntity product = productRepository.findOnById(id);
			if(product == null)
			{
				return new ResponseEntity<>("product not found", HttpStatus.BAD_REQUEST);
			}
			else
			{
				ProductEntity productEntity = new ProductEntity(productDto);
				productEntity.setId(product.getId());
				productRepository.save(productEntity);
				return new ResponseEntity<>(productEntity, HttpStatus.OK);
			}

		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
