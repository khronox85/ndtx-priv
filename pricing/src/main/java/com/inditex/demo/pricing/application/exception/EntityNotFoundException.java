package com.inditex.demo.pricing.application.exception;

public class EntityNotFoundException extends RuntimeException {

  private static final String MSG_DEFAULT = "Entity not found";

  public EntityNotFoundException() {
    super(MSG_DEFAULT);
  }

}
