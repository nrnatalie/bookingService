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

  /**
   * Регистрирует нового пользователя в системе.
   * @param userDto DTO пользователя с данными для регистрации.
   * @return Зарегистрированный пользователь.
   */
  public JpaUser registerNewUser(UserDto userDto) {
    JpaUser newUser = new JpaUser();
    newUser.setEmail(userDto.getEmail());
    // Хеширование пароля перед сохранением
    newUser.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
    // Дополнительные поля можно добавить здесь
    return userRepository.save(newUser);
  }
}