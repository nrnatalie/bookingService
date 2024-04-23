package de.aittr.g_27_bookingService.domain;

import java.util.Objects;

public class SignUpDto {
  private String email;
  private String password;
  private String confirmPassword;


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

  public String getConfirmPassword() {
    return confirmPassword;
  }

  public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
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
    return Objects.equals(email, signUpDto.email) && Objects.equals(password,
        signUpDto.password) && Objects.equals(confirmPassword, signUpDto.confirmPassword);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, password, confirmPassword);
  }

  @Override
  public String toString() {
    return "SignUpDto{" +
        "email='" + email + '\'' +
        ", password='" + password + '\'' +
        ", confirmPassword='" + confirmPassword + '\'' +
        '}';
  }
}
