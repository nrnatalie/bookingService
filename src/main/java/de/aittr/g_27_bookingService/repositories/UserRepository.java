package de.aittr.g_27_bookingService.repositories;

import de.aittr.g_27_bookingService.domain.JpaUser;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<JpaUser, Integer> {
  Optional<JpaUser> findByEmail(String email);
}