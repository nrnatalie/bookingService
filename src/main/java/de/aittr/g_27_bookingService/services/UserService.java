package de.aittr.g_27_bookingService.services;

import de.aittr.g_27_bookingService.domain.JpaUser;

import de.aittr.g_27_bookingService.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.userRepository = userRepository;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  public void registerUser(JpaUser user) {
    if (userRepository.findByEmail(user.getEmail()).isPresent()) {
      throw new RuntimeException("User with email " + user.getEmail() + " already exists.");
    }
    String hashedPassword = bCryptPasswordEncoder.encode(user.getPassword());
    user.setPassword(hashedPassword);
    userRepository.save(
        user);
  }
}