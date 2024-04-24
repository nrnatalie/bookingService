package de.aittr.g_27_bookingService.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "sign_ups")
public class JpaSignUp implements SignUp{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "username") // Добавлено поле username
  private String username;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;

  public JpaSignUp() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

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
    JpaSignUp jpaSignUp = (JpaSignUp) o;
    return Objects.equals(id, jpaSignUp.id) && Objects.equals(email,
        jpaSignUp.email) && Objects.equals(password, jpaSignUp.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, email, password);
  }

  @Override
  public String toString() {
    return "JpaSignUp{" +
        "id=" + id +
        ", email='" + email + '\'' +
        ", password='" + password + '\'' +
        '}';
  }
}