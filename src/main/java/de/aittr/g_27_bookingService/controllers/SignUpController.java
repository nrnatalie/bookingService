package de.aittr.g_27_bookingService.controllers;


import de.aittr.g_27_bookingService.domain.JpaSignUp;

import de.aittr.g_27_bookingService.domain.SignUpDto;
import de.aittr.g_27_bookingService.mappers.SignUpMapper;

import de.aittr.g_27_bookingService.services.SignUpException;
import de.aittr.g_27_bookingService.services.SignUpService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/signup")
public class SignUpController {

  @Autowired
  private SignUpService signUpService;


  @PostMapping
  @Operation(summary = "Register a new user")
  @ApiResponse(responseCode = "200", description = "User registered successfully")
  @ApiResponse(responseCode = "400", description = "Bad request. Invalid sign up data or failed to register user",
      content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
  public ResponseEntity<String> registerUser(@RequestBody SignUpDto signUpDto) throws Exception {
    try {

      if (!validateSignUpDto(signUpDto)) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid sign up data.");
      }

      JpaSignUp jpaSignUp = SignUpMapper.toEntity(signUpDto);

      JpaSignUp registeredUser = signUpService.registerUser(jpaSignUp);
      if (registeredUser != null) {
        return ResponseEntity.ok("User registered successfully.");
      } else {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to register user.");
      }
    } catch (SignUpException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }


  private boolean validateSignUpDto(SignUpDto signUpDto) {

    if (signUpDto.getEmail() == null || signUpDto.getPassword() == null) {
      return false;
    }


    if (!validateEmail(signUpDto.getEmail())) {
      return false;
    }


    if (!validatePassword(signUpDto.getPassword())) {
      return false;
    }
    return true;
  }

  private boolean validatePassword(String password) {

    return password.length() >= 6;
  }

  private boolean validateEmail(String email) {

    String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";


    return email.matches(regex);
  }
}