package de.aittr.g_27_bookingService.domain;

public class UserDto {
  private String email;
  private String password;


  public UserDto() {}

  public UserDto(String email, String password) {
    this.email = email;
    this.password = password;
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
  public String toString() {
    return "UserDto{" +
        "email='" + email + '\'' +
        ", password='[PROTECTED]'" +
        '}';
  }
}