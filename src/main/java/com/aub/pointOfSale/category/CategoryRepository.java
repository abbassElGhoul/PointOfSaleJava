package com.aub.pointOfSale.category;

import com.aub.pointOfSale.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>
{
    @Query(value = "select * from category where id = :id",nativeQuery = true)
    CategoryEntity findOnById(Long id);

}
