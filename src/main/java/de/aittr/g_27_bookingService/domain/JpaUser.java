package de.aittr.g_27_bookingService.domain;

import java.util.Objects;

public class JpaUser implements User {
  private String email;
  private String password;


  public JpaUser() {
  }

  public JpaUser(String email, String password) {
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
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    JpaUser jpaUser = (JpaUser) o;
    return Objects.equals(email, jpaUser.email) &&
        Objects.equals(password, jpaUser.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, password);
  }

  @Override
  public String toString() {
    return "JpaUser{" +
        "email='" + email + '\'' +
        ", password='[PROTECTED]'" +
        '}';
  }
}