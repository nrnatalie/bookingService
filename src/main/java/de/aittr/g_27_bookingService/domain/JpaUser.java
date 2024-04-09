package de.aittr.g_27_bookingService.domain;

import java.util.Objects;

public class JpaUser implements User{
  private String email;
  private String password;
  private String firstName;
  private String lastName;


  public JpaUser() {
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

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public JpaUser(String email, String password, String firstName, String lastName) {
    this.email = email;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JpaUser jpaUser = (JpaUser) o;
    return Objects.equals(email, jpaUser.email) && Objects.equals(password,
        jpaUser.password) && Objects.equals(firstName, jpaUser.firstName)
        && Objects.equals(lastName, jpaUser.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, password, firstName, lastName);
  }

  @Override
  public String toString() {
    return "JpaUser{" +
        "email='" + email + '\'' +
        ", password='" + password + '\'' +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
  }
}
