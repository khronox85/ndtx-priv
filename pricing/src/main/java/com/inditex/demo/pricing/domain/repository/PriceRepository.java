package com.inditex.demo.pricing.domain.repository;

import com.inditex.demo.pricing.domain.model.Price;
import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

  Price findTopByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
      final Long productId,
      final Long brandId,
      final LocalDateTime startDate,
      final LocalDateTime endDate
  );
}
