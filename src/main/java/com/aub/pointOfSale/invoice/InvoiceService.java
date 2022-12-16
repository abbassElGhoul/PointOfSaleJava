package com.aub.pointOfSale.invoice;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface InvoiceService
{

	ResponseEntity<?>  generateReceipt(GenerateReceiptDTO generateReceiptDTO);

	ResponseEntity<?>  returnInvoice(GenerateReceiptDTO generateReceiptDTO);
}
