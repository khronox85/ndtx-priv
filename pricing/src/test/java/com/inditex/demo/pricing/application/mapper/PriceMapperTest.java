package com.inditex.demo.pricing.application.mapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.inditex.demo.pricing.application.dto.PriceDto;
import com.inditex.demo.pricing.domain.model.Price;
import org.instancio.Instancio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PriceMapperTest {
  private PriceMapper mapper;

  @BeforeEach
  void setUp() {
    this.mapper = Mappers.getMapper(PriceMapper.class);
  }

  @Test
  void testAsPriceDto() {
    final Price price = Instancio.create(Price.class);
    final PriceDto result = this.mapper.asPriceDto(price);

    assertNotNull(result);
    assertThat(price)
        .usingRecursiveComparison()
        .isEqualTo(result);
  }

  @Test
  void testAsPriceDtoWhenNull() {
    final PriceDto result = this.mapper.asPriceDto(null);

    assertNull(result);
  }
}