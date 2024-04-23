package de.aittr.g_27_bookingService.mappers;

import de.aittr.g_27_bookingService.domain.JpaSignUp;
import de.aittr.g_27_bookingService.domain.SignUpDto;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SignUpMapper {

  private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

  // Метод преобразует SignUpDto в JpaSignUp
  public static JpaSignUp toEntity(SignUpDto dto) {
    if (dto == null) {
      return null;
    }
    JpaSignUp signUp = new JpaSignUp(); // Создание нового экземпляра JpaSignUp
    signUp.setEmail(dto.getEmail()); // Установка email из DTO
    signUp.setPassword(encoder.encode(dto.getPassword())); // Установка и шифрование пароля
    return signUp; // Возвращение объекта JpaSignUp
  }

  // Метод преобразует JpaSignUp в SignUpDto
  public static SignUpDto toDto(JpaSignUp jpaSignUp) {
    if (jpaSignUp == null) {
      return null;
    }
    SignUpDto dto = new SignUpDto(); // Создание нового экземпляра SignUpDto
    dto.setEmail(jpaSignUp.getEmail()); // Установка email
    dto.setPassword(""); // Пароль не включаем для безопасности
    return dto; // Возвращение объекта SignUpDto
  }
}