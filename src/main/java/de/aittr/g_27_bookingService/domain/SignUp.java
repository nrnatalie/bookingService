package de.aittr.g_27_bookingService.domain;

public interface SignUp {
  String getUsername();
  void setUsername(String username);

  String getEmail();
  void setEmail(String email);

  String getPassword();
  void setPassword(String password);
}