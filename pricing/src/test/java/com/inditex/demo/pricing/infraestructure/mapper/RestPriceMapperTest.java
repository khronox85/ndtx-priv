package com.inditex.demo.pricing.infraestructure.mapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.inditex.demo.pricing.domain.model.dto.PriceDto;
import com.inditex.demo.pricing.infraestructure.dto.RestPriceDto;
import org.instancio.Instancio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RestPriceMapperTest {

  private RestPriceMapper mapper;

  @BeforeEach
  void setUp() {
    this.mapper = Mappers.getMapper(RestPriceMapper.class);
  }

  @Test
  void testAsRestPriceDto() {
    final PriceDto priceDto = Instancio.create(PriceDto.class);
    final RestPriceDto result = this.mapper.asRestPriceDto(priceDto);

    assertNotNull(result);
    assertThat(priceDto)
        .usingRecursiveComparison()
        .ignoringFields("priceId", "priority", "curr")
        .isEqualTo(result);
  }

  @Test
  void testAsRestPriceDtoWhenNull() {
    final RestPriceDto result = this.mapper.asRestPriceDto(null);

    assertNull(result);
  }
}
