package com.aub.pointOfSale.invoice;

import com.aub.pointOfSale.invoiceProduct.InvoiceProduct;
import com.aub.pointOfSale.product.ProductEntity;
import lombok.Data;
import org.hibernate.annotations.WhereJoinTable;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "invoice")
@Data
public class InvoiceEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	private Date createdDate;

//	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinTable(name = "invoice_product", joinColumns = { @JoinColumn(name = "product_id", referencedColumnName = "product_id") }, inverseJoinColumns = {
//			@JoinColumn(name = "invoice_id", referencedColumnName = "invoice_id") })
//	@WhereJoinTable(clause = "active = true")
//	private List<InvoiceProduct> invoiceProductId;

//	private Integer total;
}
