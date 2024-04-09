package de.aittr.g_27_bookingService.domain;
public interface Registration {
  String getEmail();
  void setEmail(String email);

  String getPassword();
  void setPassword(String password);

  String getLogin();
  void setLogin(String login);
}