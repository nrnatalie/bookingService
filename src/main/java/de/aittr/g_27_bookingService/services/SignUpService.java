package de.aittr.g_27_bookingService.services;

import de.aittr.g_27_bookingService.domain.JpaSignUp;
import de.aittr.g_27_bookingService.repositories.SignUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SignUpService {

  private final SignUpRepository signUpRepository;
  private final BCryptPasswordEncoder passwordEncoder; // Объявление переменной passwordEncoder

  @Autowired
  public SignUpService(SignUpRepository signUpRepository, BCryptPasswordEncoder passwordEncoder) {
    this.signUpRepository = signUpRepository;
    this.passwordEncoder = passwordEncoder; // Инициализация переменной passwordEncoder
  }

  @Transactional
  public JpaSignUp registerUser(JpaSignUp newUser) throws Exception {
    if (newUser == null) {
      throw new IllegalArgumentException("User data cannot be null");
    }

    if (signUpRepository.findByEmail(newUser.getEmail()).isPresent()) {
      throw new Exception("User with this email already exists.");
    }


    newUser.setId(0);


    newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));

    return signUpRepository.save(newUser);
  }
}