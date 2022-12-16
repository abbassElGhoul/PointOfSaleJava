package com.aub.pointOfSale.invoice;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/invoice")
@RequiredArgsConstructor
public class InvoiceController
{

	private final InvoiceService invoiceService;
	@PostMapping("generate-receipt")
	private ResponseEntity<?> generateReceipt(@RequestBody GenerateReceiptDTO generateReceiptDTO)
	{
		return  invoiceService.returnInvoice(generateReceiptDTO);
	}
}
