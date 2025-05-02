package com.inditex.demo.pricing.domain.model.dto;

import java.time.LocalDateTime;

public record PriceDto(Long priceId,
                       Long productId,
                       Long brandId,
                       Long priceListId,
                       LocalDateTime startDate,
                       LocalDateTime endDate,
                       Integer priority,
                       Double productPrice,
                       String curr) {}
