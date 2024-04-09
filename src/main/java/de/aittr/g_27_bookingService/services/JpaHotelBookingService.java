package de.aittr.g_27_bookingService.services;

import de.aittr.g_27_bookingService.domain.HotelBookingDto;
import de.aittr.g_27_bookingService.domain.JpaHotelBooking;
import de.aittr.g_27_bookingService.mappers.HotelBookingDtoMapper;
import de.aittr.g_27_bookingService.repositories.HotelBookingRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class JpaHotelBookingService {

  @Autowired
  private HotelBookingRepository hotelBookingRepository;

  @Autowired
  private HotelBookingDtoMapper mapper;

  public HotelBookingDto createHotelBooking(HotelBookingDto hotelBookingDto) {
    JpaHotelBooking jpaHotelBooking = mapper.convertToJpaHotelBooking(hotelBookingDto);
    JpaHotelBooking createdBooking = hotelBookingRepository.save(jpaHotelBooking);
    return mapper.convertToHotelBookingDto(createdBooking);
  }

  public void createHotelBooking(JpaHotelBooking hotelBooking) {
    hotelBookingRepository.save(hotelBooking);
  }

  public JpaHotelBooking getHotelBookingById(int hotelBookingId) {
    return hotelBookingRepository.findById(hotelBookingId).orElse(null);
  }

  public List<JpaHotelBooking> getAllHotelBookings() {
    return hotelBookingRepository.findAll();
  }

  public JpaHotelBooking updateHotelBooking(int hotelBookingId, JpaHotelBooking updatedHotelBooking) {
    JpaHotelBooking existingHotelBooking = hotelBookingRepository.findById(hotelBookingId).orElse(null);
    if (existingHotelBooking != null) {

      existingHotelBooking.setDestination(updatedHotelBooking.getDestination());
      existingHotelBooking.setHotelPreference(updatedHotelBooking.getHotelPreference());
      existingHotelBooking.setCheckInDate(updatedHotelBooking.getCheckInDate());
      existingHotelBooking.setCheckOutDate(updatedHotelBooking.getCheckOutDate());
      existingHotelBooking.setAdults(updatedHotelBooking.getAdults());
      existingHotelBooking.setChildren(updatedHotelBooking.getChildren());
      existingHotelBooking.setRooms(updatedHotelBooking.getRooms());
      existingHotelBooking.setTicketPrice(updatedHotelBooking.getTicketPrice());
      existingHotelBooking.setPaymentMethod(updatedHotelBooking.getPaymentMethod());
      return hotelBookingRepository.save(existingHotelBooking);
    }
    return null;
  }

  public void deleteHotelBooking(int hotelBookingId) {
    hotelBookingRepository.deleteById(hotelBookingId);
  }
}