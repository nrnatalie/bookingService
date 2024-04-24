package de.aittr.g_27_bookingService.domain;

import java.util.Objects;

public class SignUpDto {
  private String username;
  private String email;
  private String password;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SignUpDto signUpDto = (SignUpDto) o;
    return Objects.equals(username, signUpDto.username) &&
        Objects.equals(email, signUpDto.email) &&
        Objects.equals(password, signUpDto.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, email, password);
  }

  @Override
  public String toString() {
    return "SignUpDto{" +
        "username='" + username + '\'' +
        ", email='" + email + '\'' +
        ", password='" + password + '\'' +
        '}';
  }
}