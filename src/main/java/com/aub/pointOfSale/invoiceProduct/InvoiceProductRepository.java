package com.aub.pointOfSale.invoiceProduct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceProductRepository extends JpaRepository<InvoiceProduct,Long>
{
	@Query(value = "select * from invoice_product where invoice_id = :id",nativeQuery = true)
	List<InvoiceProduct> getByInvoiceId(Long id);
}
