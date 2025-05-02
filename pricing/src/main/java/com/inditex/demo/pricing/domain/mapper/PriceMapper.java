package com.inditex.demo.pricing.domain.mapper;

import com.inditex.demo.pricing.domain.model.Price;
import com.inditex.demo.pricing.domain.model.dto.PriceDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PriceMapper {

  PriceDto asPriceDto(final Price price);
}
