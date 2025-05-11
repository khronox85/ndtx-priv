package com.inditex.demo.pricing.infraestructure.controller;

import com.inditex.demo.pricing.application.usecase.GetProductPriceInDateUseCase;
import com.inditex.demo.pricing.infraestructure.dto.RestPriceDto;
import com.inditex.demo.pricing.infraestructure.mapper.RestPriceMapper;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/price")
@Validated
@RequiredArgsConstructor
public class PriceController {
  private final GetProductPriceInDateUseCase getProductPriceInDateUseCase;
  private final RestPriceMapper restPriceMapper;

  @GetMapping
  public ResponseEntity<RestPriceDto> getProductPrice(
      @Parameter(name = "applicationDate", description = "Application date", example = "2020-06-14T16:00:00")
      @RequestParam @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) final LocalDateTime applicationDate,
      @Parameter(name = "productId", description = "Product identifier", example = "35455")
      @RequestParam @NotNull final Long productId,
      @Parameter(name = "brandId", description = "Brand identifier", example = "1")
      @RequestParam @NotNull final Long brandId) {
      return ResponseEntity.ok(this.restPriceMapper
          .asRestPriceDto(
              this.getProductPriceInDateUseCase.execute(applicationDate, productId, brandId)));
  }
}