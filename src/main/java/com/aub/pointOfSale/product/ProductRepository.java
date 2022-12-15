package com.aub.pointOfSale.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long>
{



	@Query(value = "select * from product where id = :id",nativeQuery = true)
	ProductEntity findOnById(Long id);

}
