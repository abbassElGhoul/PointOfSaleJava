package com.aub.pointOfSale.invoiceProduct;

import com.aub.pointOfSale.invoice.InvoiceEntity;
import com.aub.pointOfSale.product.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "invoice_product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private ProductEntity product;

	@ManyToOne
	@JoinColumn(name = "invoice_id")
	private InvoiceEntity invoice;

	@Column(name = "quantity")
	private Integer quantity;

}
