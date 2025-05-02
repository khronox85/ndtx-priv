package com.inditex.demo.pricing.infraestructure.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.inditex.demo.pricing.application.usecase.GetProductPriceInDateUseCase;
import com.inditex.demo.pricing.infraestructure.mapper.RestPriceMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Mock
  private GetProductPriceInDateUseCase getProductPriceInDateUseCase;

  @Mock
  private RestPriceMapper restPriceMapper;

  // Requested tests
  @ParameterizedTest
  @CsvSource({"2020-06-14T10:00:00, 35455, 1, 35.50",
      "2020-06-14T16:00:00, 35455, 1, 25.45",
      "2020-06-14T21:00:00, 35455, 1, 35.50",
      "2020-06-15T10:00:00, 35455, 1, 30.50",
      "2020-06-16T21:00:00, 35455, 1, 38.95",})
  void testPriceRequestAtDayAndProductAndBrandWithExpectedPrice(String appDate, String productId, String brandId,
                                                                Double priceExpected)
      throws Exception {
    mockMvc.perform(get("/price")
            .param("applicationDate", appDate)
            .param("productId", productId)
            .param("brandId", brandId))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.productPrice").value(priceExpected));
  }

  // Other Tests
  @ParameterizedTest
  @CsvSource({", 35455, 1",
      "2020-06-14T16:00:00, , 1",
      "2020-06-14T21:00:00, 35455, "})
  void shouldReturn400WhenAnyParamIsMissed(String appDate, String productId, String brandId) throws Exception {
    mockMvc.perform(get("/price")
            .param("applicationDate", appDate)
            .param("productId", productId)
            .param("brandId", brandId))
        .andExpect(status().isBadRequest());
  }

  @Test
  void shouldReturn404WhenEntityNotFound() throws Exception {
    mockMvc.perform(get("/price")
            .param("applicationDate", "2020-06-14T10:00:00")
            .param("productId", "11")
            .param("brandId", "11"))
        .andExpect(status().isNotFound());
  }

}
