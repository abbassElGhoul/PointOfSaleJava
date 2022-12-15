package com.aub.pointOfSale.invoice;

import com.aub.pointOfSale.product.ProductEntity;
import com.aub.pointOfSale.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InvoiceServiceImpl implements InvoiceService
{
	private final InvoiceRepository invoiceRepository;

	private final ProductRepository productRepository;

	@Override
	public ResponseEntity<?> generateReceipt(GenerateReceiptDTO generateReceiptDTO)
	{
		try
		{
			for(ProductAndQuantity productAndQuantity : generateReceiptDTO.getProductAndQuantityList())
			{
				ProductEntity product = productRepository.findOnById(productAndQuantity.getProductId());
				if(checkProductAvailability(product, productAndQuantity.getQuantity()))
				{
					product.setQuantity(product.getQuantity() - productAndQuantity.getQuantity());
					productRepository.save(product);
				}
				else
				{
					return new ResponseEntity<>("there is not enough " + product.getName() + "in the inventory", HttpStatus.BAD_REQUEST);
				}
			}
			return new ResponseEntity<>("success",HttpStatus.OK);
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	private boolean checkProductAvailability(ProductEntity product, int quantity)
	{
		if(product.getQuantity() - quantity < 0)
		{
			return false;
		}
		return true;
	}
}
