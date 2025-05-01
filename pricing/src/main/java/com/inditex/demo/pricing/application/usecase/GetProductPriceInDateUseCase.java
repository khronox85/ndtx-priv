package com.inditex.demo.pricing.application.usecase;

import com.inditex.demo.pricing.domain.model.dto.PriceDto;

import java.time.LocalDate;

public interface GetProductPriceInDateUseCase {

  PriceDto execute(LocalDate applicationDate, Long productId, Long brandId);
}
