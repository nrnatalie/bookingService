package de.aittr.g_27_bookingService.repositories;

import de.aittr.g_27_bookingService.domain.JpaHotelBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelBookingRepository extends JpaRepository<JpaHotelBooking, Integer> {

}
