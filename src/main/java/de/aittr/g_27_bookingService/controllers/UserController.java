//package de.aittr.g_27_bookingService.controllers;
//
//import de.aittr.g_27_bookingService.domain.UserDto;
//
//import de.aittr.g_27_bookingService.services.JpaUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api")
//public class UserController {
//
//  private final JpaUserService userService;
//
//  @Autowired
//  public UserController(JpaUserService userService) {
//    this.userService = userService;
//  }
//
//  @PostMapping("/registration")
//  public ResponseEntity<?> registerUser(@RequestBody UserDto userDto) {
//    try {
//      userService.registerNewUser(userDto);
//      return ResponseEntity.status(HttpStatus.OK).body("Registration successful");
//    } catch (Exception e) {
//      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//    }
//  }
//
//
//}

package de.aittr.g_27_bookingService.controllers;

import de.aittr.g_27_bookingService.domain.JpaUser;

import de.aittr.g_27_bookingService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserService userService;


  @PostMapping
  public ResponseEntity<JpaUser> createUser(@RequestBody JpaUser user) {
    JpaUser savedUser = userService.createUser(user);
    return ResponseEntity.ok(savedUser);
  }


  @GetMapping
  public ResponseEntity<List<JpaUser>> getAllUsers() {
    List<JpaUser> users = userService.findAllUsers();
    return ResponseEntity.ok(users);
  }


  @GetMapping("/{id}")
  public ResponseEntity<JpaUser> getUserById(@PathVariable int id) {
    JpaUser user = userService.findUserById(id);
    if (user != null) {
      return ResponseEntity.ok(user);
    } else {
      return ResponseEntity.notFound().build();
    }
  }


  @PutMapping("/{id}")
  public ResponseEntity<JpaUser> updateUser(@PathVariable int id, @RequestBody JpaUser user) {
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