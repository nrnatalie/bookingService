package de.aittr.g_27_bookingService.services;
import de.aittr.g_27_bookingService.domain.JpaUser;
import de.aittr.g_27_bookingService.repositories.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private PasswordEncoder passwordEncoder;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }


  public void registerUser(JpaUser user) {

    if (userRepository.findByEmail(user.getEmail()).isPresent()) {
      throw new RuntimeException("User with email " + user.getEmail() + " already exists.");
    }

    String hashedPassword = passwordEncoder.encode(user.getPassword());
    user.setPassword(hashedPassword);
    userRepository.save(user);
  }

  public JpaUser createUser(JpaUser user) {

    String encodedPassword = passwordEncoder.encode(user.getPassword());
    user.setPassword(encodedPassword);

    return userRepository.save(user);
  }

  public List<JpaUser> findAllUsers() {
    return userRepository.findAll();
  }

  public JpaUser findUserById(int id) {
    return userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
  }


  public JpaUser updateUser(int id, JpaUser user) {

    JpaUser existingUser = userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

    existingUser.setEmail(user.getEmail());
    existingUser.setPassword(passwordEncoder.encode(user.getPassword()));

    return userRepository.save(existingUser);
  }

  //  public boolean deleteUser(int id) {
//    // Проверяем, существует ли пользователь с данным ID
//    JpaUser user = userRepository.findById(id)
//        .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
//
//    // Удаление пользователя из репозитория
//    userRepository.delete(user);
//
//
//    return true;
//  }
//}

  public boolean deleteUser(int id) {
    return userRepository.findById(id).map(user -> {
      userRepository.delete(user);
      return true;
    }).orElse(false);
  }

  public boolean checkEmailExists(String email) {
    return userRepository.findByEmail(email).isPresent();
  }

  public boolean validateEmail(String email) {
    if (email == null) {
      return false;
    }
    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    return email.matches(emailRegex);
  }

  public boolean validatePassword(String password) {
    if (password == null) {
      return false;
    }
    int minLength = 8;

    String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{" + minLength + ",}$";

    return password.matches(passwordRegex);
  }
}