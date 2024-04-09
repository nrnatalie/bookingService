package de.aittr.g_27_bookingService.domain;

public interface User {
  String getEmail();
  void setEmail(String email);

  String getPassword();
  void setPassword(String password);

  String getFirstName();
  void setFirstName(String firstName);

  String getLastName();
  void setLastName(String lastName);
}
