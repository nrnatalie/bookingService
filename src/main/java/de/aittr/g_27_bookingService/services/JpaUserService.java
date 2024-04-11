package de.aittr.g_27_bookingService.services;

import de.aittr.g_27_bookingService.domain.JpaUser;
import de.aittr.g_27_bookingService.domain.UserDto;
import de.aittr.g_27_bookingService.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JpaUserService {

  private final UserRepository userRepository;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  public JpaUserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.userRepository = userRepository;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  public JpaUser registerNewUser(UserDto userDto) {
    JpaUser newUser = new JpaUser();
    newUser.setEmail(userDto.getEmail());
    newUser.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
    return userRepository.save(newUser);
  }
}
