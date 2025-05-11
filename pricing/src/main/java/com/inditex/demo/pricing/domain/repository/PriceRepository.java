package com.inditex.demo.pricing.domain.repository;

import com.inditex.demo.pricing.domain.model.Price;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
  @Query(value = """
    SELECT * FROM prices
    WHERE product_id = :productId
      AND brand_id = :brandId
      AND :applicationDate BETWEEN start_date AND end_date
    ORDER BY priority DESC
    LIMIT 1
    """, nativeQuery = true)
  Optional<Price> findApplicablePrice(
      @Param("productId") Long productId,
      @Param("brandId") Long brandId,
      @Param("applicationDate") LocalDateTime applicationDate
  );
}