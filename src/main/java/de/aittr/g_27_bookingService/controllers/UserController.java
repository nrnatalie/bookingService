
package de.aittr.g_27_bookingService.controllers;
import de.aittr.g_27_bookingService.domain.JpaUser;
import de.aittr.g_27_bookingService.domain.User;
import de.aittr.g_27_bookingService.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/register")
  @Operation(summary = "Register a new user", description = "Provide an email and password to register a new user",
      responses = {
          @ApiResponse(responseCode = "200", description = "User registered successfully",
              content = @Content(schema = @Schema(implementation = JpaUser.class))),
          @ApiResponse(responseCode = "400", description = "Invalid email format or password does not meet security requirements"),
          @ApiResponse(responseCode = "409", description = "Email already exists")
      }
  )

  public ResponseEntity<JpaUser> createUser(@RequestBody User user) {
    if (!isValidEmail(user.getEmail())) {
      return ResponseEntity.badRequest().body(null);
    }
    if (!isValidPassword(user.getPassword())) {
      return ResponseEntity.badRequest().body(null);
    }
    if (userService.checkEmailExists(user.getEmail())) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
    }

    JpaUser jpaUser = convertUserToJpaUser(user);
    JpaUser savedUser = userService.createUser(jpaUser);
    return ResponseEntity.ok(savedUser);
  }

  private boolean isValidEmail(String email) {
    String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
    return email.matches(regex);
  }

  private boolean isValidPassword(String password) {
    return password.length() >= 8;
  }

  private JpaUser convertUserToJpaUser(User user) {

    JpaUser jpaUser = new JpaUser();
    jpaUser.setEmail(user.getEmail());
    jpaUser.setPassword(user.getPassword());

    return jpaUser;
  }

  @GetMapping
  public ResponseEntity<List<JpaUser>> getAllUsers() {
    List<JpaUser> users = userService.findAllUsers();
    return ResponseEntity.ok(users);
  }


  @GetMapping("/{id}")
  public ResponseEntity<JpaUser> getUserById(@PathVariable int id) {
    if (!userService.existsById(id)) {
      return ResponseEntity.notFound().build();
    }

    JpaUser user = userService.findUserById(id);
    if (user != null) {
      return ResponseEntity.ok(user);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PutMapping("/{id}")
  @Operation(summary = "Update an existing user", description = "Updates user details by ID",
      responses = {
          @ApiResponse(responseCode = "200", description = "User updated successfully", content = @Content(schema = @Schema(implementation = JpaUser.class))),
          @ApiResponse(responseCode = "400", description = "Invalid email format or password does not meet security requirements"),
          @ApiResponse(responseCode = "404", description = "User not found")
      }
  )
  public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody JpaUser user) {
    if (!userService.existsById(id)) {
      return ResponseEntity.notFound().build();
    }
    if (!isValidEmail(user.getEmail())) {
      return ResponseEntity.badRequest().body("Invalid email format.");
    }
    if (!isValidPassword(user.getPassword())) {
      return ResponseEntity.badRequest().body("Password does not meet security requirements.");
    }

    JpaUser updatedUser = userService.updateUser(id, user);
    if (updatedUser != null) {
      return ResponseEntity.ok(updatedUser);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable int id) {
    boolean isDeleted = userService.deleteUser(id);
    if (isDeleted) {
      return ResponseEntity.ok().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}