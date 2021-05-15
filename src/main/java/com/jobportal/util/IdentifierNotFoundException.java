package com.jobportal.util;

public class IdentifierNotFoundException extends RuntimeException {
  public IdentifierNotFoundException() {
    super("ID not found");
  }
}
