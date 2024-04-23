package de.aittr.g_27_bookingService.services;

import de.aittr.g_27_bookingService.domain.JpaSignUp;
import de.aittr.g_27_bookingService.repository.SignUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SignUpService {

  @Autowired
  private SignUpRepository signUpRepository;

  @Transactional
  public JpaSignUp registerUser(JpaSignUp newUser) throws Exception {

    if (signUpRepository.findByEmail(newUser.getEmail()).isPresent()) {
      throw new Exception("User with this email already exists.");
    }


    return signUpRepository.save(newUser);
  }
}