package de.aittr.g_27_bookingService.repository;

import de.aittr.g_27_bookingService.domain.JpaSignUp;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SignUpRepository extends JpaRepository<JpaSignUp, Long> {
  Optional<JpaSignUp> findByEmail(String email);
}