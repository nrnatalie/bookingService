package de.aittr.g_27_bookingService.services;

import de.aittr.g_27_bookingService.domain.JpaSignUp;
import de.aittr.g_27_bookingService.repositories.SignUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class JpaSignUpService {

  private final SignUpRepository signUpRepository;
  private final BCryptPasswordEncoder passwordEncoder;

  @Autowired
  public JpaSignUpService(SignUpRepository signUpRepository, BCryptPasswordEncoder passwordEncoder) {
    this.signUpRepository = signUpRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Transactional
  public JpaSignUp registerUser(JpaSignUp newUser) throws SignUpException {
    if (newUser == null) {
      throw new IllegalArgumentException("User data cannot be null");
    }

    if (signUpRepository.findByEmail(newUser.getEmail()).isPresent()) {
      throw new SignUpException("User with this email already exists.");
    }

    // Установка id на 0 перед сохранением нового пользователя
    newUser.setId(0);

    newUser.setPassword(hashPassword(newUser.getPassword()));

    return signUpRepository.save(newUser);
  }

  private String hashPassword(String password) {
    return passwordEncoder.encode(password);
  }
}