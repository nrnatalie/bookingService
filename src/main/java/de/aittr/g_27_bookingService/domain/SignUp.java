package de.aittr.g_27_bookingService.domain;
public interface SignUp {
  String getEmail();
  void setEmail(String email);

  String getPassword();
  void setPassword(String password);

  String getConfirmPassword();
  void setConfirmPassword(String confirmPassword);
}