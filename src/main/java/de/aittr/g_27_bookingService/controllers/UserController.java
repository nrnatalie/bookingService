package de.aittr.g_27_bookingService.controllers;

import de.aittr.g_27_bookingService.domain.UserDto;

import de.aittr.g_27_bookingService.services.JpaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

  private final JpaUserService userService;

  @Autowired
  public UserController(JpaUserService userService) {
    this.userService = userService;
  }

  @PostMapping("/registration")
  public ResponseEntity<?> registerUser(@RequestBody UserDto userDto) {
    try {
      userService.registerNewUser(userDto);
      return ResponseEntity.status(HttpStatus.OK).body("Registration successful");
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }


}