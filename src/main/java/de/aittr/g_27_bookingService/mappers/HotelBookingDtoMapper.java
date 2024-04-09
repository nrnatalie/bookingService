package de.aittr.g_27_bookingService.mappers;
import de.aittr.g_27_bookingService.domain.HotelBookingDto;
import de.aittr.g_27_bookingService.domain.JpaHotelBooking;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class HotelBookingDtoMapper {

  public JpaHotelBooking convertToJpaHotelBooking(HotelBookingDto hotelBookingDto) {
    JpaHotelBooking jpaHotelBooking = new JpaHotelBooking();

    return jpaHotelBooking;
  }

  public HotelBookingDto convertToHotelBookingDto(JpaHotelBooking jpaHotelBooking) {
    HotelBookingDto hotelBookingDto = new HotelBookingDto();

    return hotelBookingDto;
  }

  public List<HotelBookingDto> convertToHotelBookingDtoList(List<JpaHotelBooking> jpaHotelBookings) {
    List<HotelBookingDto> hotelBookingDtos = new ArrayList<>();
    for (JpaHotelBooking jpaHotelBooking : jpaHotelBookings) {
      HotelBookingDto hotelBookingDto = convertToHotelBookingDto(jpaHotelBooking);
      hotelBookingDtos.add(hotelBookingDto);
    }
    return hotelBookingDtos;
  }
}