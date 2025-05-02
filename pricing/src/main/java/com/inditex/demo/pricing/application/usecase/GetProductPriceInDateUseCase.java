package com.inditex.demo.pricing.application.usecase;

import com.inditex.demo.pricing.application.exception.EntityNotFoundException;
import com.inditex.demo.pricing.domain.model.dto.PriceDto;
import java.time.LocalDateTime;

public interface GetProductPriceInDateUseCase {

  PriceDto execute(final LocalDateTime applicationDate, final Long productId, final Long brandId)
      throws EntityNotFoundException;
}
