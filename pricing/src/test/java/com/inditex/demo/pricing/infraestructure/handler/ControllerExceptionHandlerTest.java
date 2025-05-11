package com.inditex.demo.pricing.infraestructure.handler;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class ControllerExceptionHandlerTest {
  private ControllerExceptionHandler exceptionHandler;

  @BeforeEach
  void setUp() {
    exceptionHandler = new ControllerExceptionHandler();
  }

  @Test
  void handleGenericException_shouldReturnInternalServerErrorAndExpectedMessage() {
    final Exception exception = new RuntimeException("Unexpected failure");

    final ResponseEntity<Object> response = exceptionHandler.handleGenericException(exception);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    assertThat(response.getBody()).isInstanceOf(Map.class);

    final Map<String, Object> body = (Map<String, Object>) response.getBody();
    assertThat(body).containsEntry("message", "An unexpected error occurred, please contact support team");
    assertThat(body).containsKey("timestamp");
  }
}