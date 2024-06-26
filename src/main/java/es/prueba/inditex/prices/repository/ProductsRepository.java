package es.prueba.inditex.prices.repository;

import es.prueba.inditex.prices.model.PriceRequestDto;
import es.prueba.inditex.prices.repository.entities.ProductEntity;
import es.prueba.inditex.prices.repository.entities.ProductPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<ProductEntity, ProductPK> {

    //use SpEL language to extract object properties tu use in query
   @Query(value = "select * from PRICES where PRODUCT_ID = :#{#request.productId} and " +
           "BRAND_ID = :#{#request.brandId} and " +
           "(START_DATE <= :#{#request.applicationDate} and END_DATE >= :#{#request.applicationDate})",
           nativeQuery = true)
   List<ProductEntity> findProductRate(@Param("request") PriceRequestDto requestDto);

}
