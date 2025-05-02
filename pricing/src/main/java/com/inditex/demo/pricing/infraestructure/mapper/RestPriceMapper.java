package com.inditex.demo.pricing.infraestructure.mapper;

import com.inditex.demo.pricing.domain.model.dto.PriceDto;
import com.inditex.demo.pricing.infraestructure.dto.RestPriceDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestPriceMapper {

  RestPriceDto asRestPriceDto(final PriceDto priceDto);
}
