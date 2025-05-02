package com.inditex.demo.pricing.domain.service.impl;

import com.inditex.demo.pricing.domain.mapper.PriceMapper;
import com.inditex.demo.pricing.domain.model.dto.PriceDto;
import com.inditex.demo.pricing.domain.repository.PriceRepository;
import com.inditex.demo.pricing.domain.service.PriceService;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {

  private final PriceRepository priceRepository;

  private final PriceMapper priceMapper;

  @Override
  public PriceDto getPriceByApplicationDateAndProductAndBrand(final LocalDateTime applicationDate, final Long productId,
                                                              final Long brandId) {

    return this.priceMapper.asPriceDto(
        this.priceRepository
            .findTopByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
              productId,
              brandId,
              applicationDate,
              applicationDate));
  }
}
