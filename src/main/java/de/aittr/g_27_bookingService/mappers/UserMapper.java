package de.aittr.g_27_bookingService.mappers;
import de.aittr.g_27_bookingService.domain.User;
import de.aittr.g_27_bookingService.domain.UserDto;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserMapper {

  private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

  public static User toEntity(UserDto dto) {
    User user = new User() {
      @Override
      public String getEmail() {
        return null;
      }

      @Override
      public void setEmail(String email) {

      }

      @Override
      public String getPassword() {
        return null;
      }

      @Override
      public void setPassword(String password) {

      }
    };
    user.setEmail(dto.getEmail());
    user.setPassword(encoder.encode(dto.getPassword()));
    return user;
  }

  public static UserDto toDto(User entity) {
    UserDto dto = new UserDto();
    dto.setEmail(entity.getEmail());
    dto.setPassword(entity.getPassword());

    return dto;
  }
}