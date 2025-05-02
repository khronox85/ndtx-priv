package com.inditex.demo.pricing.domain.service;

import com.inditex.demo.pricing.domain.model.dto.PriceDto;
import java.time.LocalDateTime;

public interface PriceService {

  PriceDto getPriceByApplicationDateAndProductAndBrand(final LocalDateTime applicationDate, final Long productId,
                                                       final Long brandId);
}
