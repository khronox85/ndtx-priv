package com.inditex.demo.pricing.domain.service;

import com.inditex.demo.pricing.domain.model.dto.PriceDto;

import java.time.LocalDate;

public interface PriceService {

  PriceDto getPriceByApplicationDateAndProductAndBrand(LocalDate applicationDate, Long productId, Long brandId);
}
