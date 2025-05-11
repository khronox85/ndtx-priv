package com.inditex.demo.pricing.application.mapper;

import com.inditex.demo.pricing.application.dto.PriceDto;
import com.inditex.demo.pricing.domain.model.Price;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PriceMapper {
  PriceDto asPriceDto(final Price price);
}