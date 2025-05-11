package com.inditex.demo.pricing.application.usecase.impl;

import com.inditex.demo.pricing.application.dto.PriceDto;
import com.inditex.demo.pricing.application.exception.EntityNotFoundException;
import com.inditex.demo.pricing.application.mapper.PriceMapper;
import com.inditex.demo.pricing.application.usecase.GetProductPriceInDateUseCase;
import com.inditex.demo.pricing.domain.repository.PriceRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetProductPriceInDateUseCaseImpl implements GetProductPriceInDateUseCase {
  private final PriceRepository priceRepository;
  private final PriceMapper priceMapper;

  @Override
  public PriceDto execute(final LocalDateTime applicationDate, final Long productId, final Long brandId)
      throws EntityNotFoundException {
    return this.priceMapper.asPriceDto(
              this.priceRepository.findApplicablePrice(
                  productId,
                  brandId,
                  applicationDate).orElseThrow(EntityNotFoundException::new));
  }
}