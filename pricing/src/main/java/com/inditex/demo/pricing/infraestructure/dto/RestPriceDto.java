package com.inditex.demo.pricing.infraestructure.dto;

import java.time.LocalDateTime;

public record RestPriceDto(Long productId,
                           Long brandId,
                           Long priceListId,
                           LocalDateTime startDate,
                           LocalDateTime endDate,
                           Double productPrice) {}
