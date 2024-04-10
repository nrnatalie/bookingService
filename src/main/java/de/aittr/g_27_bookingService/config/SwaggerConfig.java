//package de.aittr.g_27_bookingService.config;
//
//import io.swagger.v3.oas.models.info.Contact;
//import java.util.Collections;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//
//
//
//
//@Configuration
//public class SwaggerConfig {
//
//  @Bean
//  public Docket api() {
//    return new Docket(DocumentationType.OAS_30)
//        .select()
//        .apis(RequestHandlerSelectors.basePackage("de.aittr.g_27_bookingService.controllers"))
//        .paths(PathSelectors.any())
//        .build()
//        .apiInfo(apiInfo());
//  }
//
//  private ApiInfo apiInfo() {
//    return new ApiInfo(
//        "Booking Service API",
//        "API для управления бронированием отелей", // Описание  API
//        "1.0", // Версия вашего API
//        "Terms of service",
//        new Contact("John Doe", "https://www.example.com", "john.doe@example.com"),
//        "MIT License", // Лицензия вашего API
//        "https://www.example.com/license", // URL лицензии вашего API
//        Collections.emptyList());
//  }
//}


