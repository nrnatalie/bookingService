package de.aittr.g_27_bookingService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {

  public static void main(String[] args) {
      String password = "ghj";
      BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
      String hashedPassword = passwordEncoder.encode(password);
      System.out.println("Hashed Password: " + hashedPassword);
    }
  }