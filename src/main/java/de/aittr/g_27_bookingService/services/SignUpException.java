package de.aittr.g_27_bookingService.services;

public class SignUpException extends Exception {
  public SignUpException() {
    super();
  }

  public SignUpException(String message) {
    super(message);
  }

  public SignUpException(String message, Throwable cause) {
    super(message, cause);
  }

  public SignUpException(Throwable cause) {
    super(cause);
  }
}
