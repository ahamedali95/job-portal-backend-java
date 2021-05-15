package com.jobportal.util;

public class ResourceNotFoundException extends Exception {
  public ResourceNotFoundException() {
    super("Resource not found");
  }
}
