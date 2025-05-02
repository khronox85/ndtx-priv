package com.inditex.demo.pricing.application.usecase.impl;

import com.inditex.demo.pricing.application.exception.EntityNotFoundException;
import com.inditex.demo.pricing.application.usecase.GetProductPriceInDateUseCase;
import com.inditex.demo.pricing.domain.model.dto.PriceDto;
import com.inditex.demo.pricing.domain.service.PriceService;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetProductPriceInDateUseCaseImpl implements GetProductPriceInDateUseCase {

  private final PriceService priceService;

  @Override
  public PriceDto execute(final LocalDateTime applicationDate, final Long productId, final Long brandId)
      throws EntityNotFoundException {

    final PriceDto priceDto =
        this.priceService.getPriceByApplicationDateAndProductAndBrand(applicationDate, productId, brandId);

    if(Objects.nonNull(priceDto)) {
      return priceDto;
    }
    else {
      throw new EntityNotFoundException();
    }
  }
}
