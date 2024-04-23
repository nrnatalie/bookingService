package de.aittr.g_27_bookingService.controllers;

import java.time.LocalDateTime;

public class ErrorResponse {
  private String message;
  private LocalDateTime timestamp;



  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }
}