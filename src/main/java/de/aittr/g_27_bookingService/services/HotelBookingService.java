package de.aittr.g_27_bookingService.services;

import de.aittr.g_27_bookingService.domain.HotelBookingDto;
import de.aittr.g_27_bookingService.domain.JpaHotelBooking;
import de.aittr.g_27_bookingService.mappers.HotelBookingDtoMapper;
import de.aittr.g_27_bookingService.repositories.HotelBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelBookingService {

  @Autowired
  private HotelBookingRepository hotelBookingRepository;

  @Autowired
  private HotelBookingDtoMapper mapper;

  public HotelBookingDto createHotelBooking(HotelBookingDto hotelBookingDto) {
    JpaHotelBooking jpaHotelBooking = mapper.convertToJpaHotelBooking(hotelBookingDto);

    jpaHotelBooking.setId(0);
    JpaHotelBooking createdBooking = hotelBookingRepository.save(jpaHotelBooking);
    return mapper.convertToHotelBookingDto(createdBooking);
  }


  public HotelBookingDto getHotelBookingById(int hotelBookingId) {
    JpaHotelBooking hotelBooking = hotelBookingRepository.findById(hotelBookingId).orElse(null);
    if (hotelBooking != null) {
      return mapper.convertToHotelBookingDto(hotelBooking);
    }
    return null;
  }

  public List<HotelBookingDto> getAllHotelBookings() {
    List<JpaHotelBooking> jpaHotelBookings = hotelBookingRepository.findAll();
    return mapper.convertToHotelBookingDtoList(jpaHotelBookings);
  }

  public HotelBookingDto updateHotelBooking(int hotelBookingId, HotelBookingDto updatedHotelBookingDto) {
    JpaHotelBooking existingHotelBooking = hotelBookingRepository.findById(hotelBookingId).orElse(null);
    if (existingHotelBooking != null) {
      JpaHotelBooking updatedHotelBooking = mapper.convertToJpaHotelBooking(updatedHotelBookingDto);
      updatedHotelBooking.setId(existingHotelBooking.getId());
      JpaHotelBooking savedHotelBooking = hotelBookingRepository.save(updatedHotelBooking);
      return mapper.convertToHotelBookingDto(savedHotelBooking);
    }
    return null;
  }

  public void deleteHotelBooking(int hotelBookingId) {
    hotelBookingRepository.deleteById(hotelBookingId);
  }
}