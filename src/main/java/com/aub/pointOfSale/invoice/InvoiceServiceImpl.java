package com.aub.pointOfSale.invoice;

import com.aub.pointOfSale.invoiceProduct.InvoiceProduct;
import com.aub.pointOfSale.invoiceProduct.InvoiceProductRepository;
import com.aub.pointOfSale.product.ProductEntity;
import com.aub.pointOfSale.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class InvoiceServiceImpl implements InvoiceService
{
	private final InvoiceRepository invoiceRepository;

	private final ProductRepository productRepository;

	private final InvoiceProductRepository invoiceProductRepository;

	@Override
	public ResponseEntity<?> generateReceipt(GenerateReceiptDTO generateReceiptDTO)
	{
		try
		{
			InvoiceEntity invoiceEntity = new InvoiceEntity();
			invoiceEntity.setCreatedDate(Timestamp.from(Instant.now()));
			InvoiceEntity invoice = invoiceRepository.save(invoiceEntity);
			List<InvoiceProduct> invoiceProductList = new ArrayList<>();
			for(ProductAndQuantity productAndQuantity : generateReceiptDTO.getProductAndQuantityList())
			{
				ProductEntity product = productRepository.findOnById(productAndQuantity.getProductId());
				if(checkProductAvailability(product, productAndQuantity.getQuantity()))
				{
					product.setQuantity(product.getQuantity() - productAndQuantity.getQuantity());
					invoiceProductList.add(new InvoiceProduct(product, invoice, productAndQuantity.getQuantity()));
					productRepository.save(product);
				}
				else
				{
					invoiceRepository.deleteById(invoice.getId());
					return new ResponseEntity<>("there is not enough " + product.getName() + "in the inventory", HttpStatus.BAD_REQUEST);
				}
			}
			invoiceProductRepository.saveAll(invoiceProductList);
			return new ResponseEntity<>(invoice, HttpStatus.OK);
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	@Override
	public ResponseEntity<?> returnInvoice(GenerateReceiptDTO generateReceiptDTO)
	{
		ResponseEntity<InvoiceEntity> response = (ResponseEntity<InvoiceEntity>) generateReceipt(generateReceiptDTO);

		try
		{
			InvoiceEntity invoice = response.getBody();
			if(response.getStatusCode().value() == 200)
			{
				List<InvoiceProduct> invoiceProductList = invoiceProductRepository.getByInvoiceId(invoice.getId());
				Map<ProductEntity, Integer> map = new HashMap<>();
				for(InvoiceProduct invoiceProduct : invoiceProductList)
				{
					map.put(invoiceProduct.getProduct(), invoiceProduct.getQuantity());
				}
				invoice.setInvoiceProduct(map);
				return new ResponseEntity<>(invoice, HttpStatus.OK);
			}
			else
			{
				return generateReceipt(generateReceiptDTO);
			}

		}
		catch(Exception e)
		{
			return response;
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
