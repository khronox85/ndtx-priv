package com.inditex.demo.pricing.infraestructure.handler;

import com.inditex.demo.pricing.application.exception.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

  private static final String UNEXPECTED_ERROR = "An unexpected error occurred, please contact support team";

  @ExceptionHandler({EntityNotFoundException.class})
  public ResponseEntity<Object> handleEntityNotFoundException(final EntityNotFoundException exception) {
    return new ResponseEntity<>(this.buildResponseBody(exception.getMessage()), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler({Exception.class})
  public ResponseEntity<Object> handleGenericException(final Exception exception) {
    return new ResponseEntity<>(this.buildResponseBody(UNEXPECTED_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  private Map<String, Object> buildResponseBody(final String message) {
    final Map<String, Object> body = new ConcurrentHashMap<>();
    body.put("timestamp", LocalDateTime.now());
    body.put("message", message);

    return body;
  }
}
