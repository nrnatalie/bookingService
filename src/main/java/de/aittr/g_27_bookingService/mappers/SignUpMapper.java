package de.aittr.g_27_bookingService.mappers;

import de.aittr.g_27_bookingService.domain.JpaSignUp;
import de.aittr.g_27_bookingService.domain.SignUpDto;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SignUpMapper {

  private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


  public static JpaSignUp toEntity(SignUpDto dto) {
    if (dto == null) {
      return null;
    }
    JpaSignUp signUp = new JpaSignUp();
    signUp.setEmail(dto.getEmail());
    signUp.setPassword(encoder.encode(dto.getPassword()));
    return signUp;
  }


  public static SignUpDto toDto(JpaSignUp jpaSignUp) {
    if (jpaSignUp == null) {
      return null;
    }
    SignUpDto dto = new SignUpDto();
    dto.setEmail(jpaSignUp.getEmail());
    dto.setPassword("");
    return dto;
  }
}