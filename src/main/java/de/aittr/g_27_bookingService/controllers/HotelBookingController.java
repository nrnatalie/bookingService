package de.aittr.g_27_bookingService.controllers;

import de.aittr.g_27_bookingService.domain.HotelBookingDto;

import de.aittr.g_27_bookingService.services.HotelBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotel-bookings")
public class HotelBookingController {

  @Autowired
  private HotelBookingService hotelBookingService;

  @PostMapping
  public ResponseEntity<HotelBookingDto> createHotelBooking(@RequestBody HotelBookingDto hotelBookingDto) {
    HotelBookingDto createdBookingDto = hotelBookingService.createHotelBooking(hotelBookingDto);
    if (createdBookingDto != null) {
      return ResponseEntity.status(HttpStatus.CREATED).body(createdBookingDto);
    } else {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<HotelBookingDto> getHotelBookingById(@PathVariable("id") int hotelBookingId) {
    HotelBookingDto hotelBooking = hotelBookingService.getHotelBookingById(hotelBookingId);
    if (hotelBooking != null) {
      return new ResponseEntity<>(hotelBooking, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
  @GetMapping
  public ResponseEntity<List<HotelBookingDto>> getAllHotelBookings() {
    List<HotelBookingDto> hotelBookings = hotelBookingService.getAllHotelBookings();
    return new ResponseEntity<>(hotelBookings, HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<HotelBookingDto> updateHotelBooking(
          @PathVariable("id") int hotelBookingId,
          @RequestBody HotelBookingDto updatedHotelBookingDto) {
    HotelBookingDto updatedBooking = hotelBookingService.updateHotelBooking(hotelBookingId, updatedHotelBookingDto);
    if (updatedBooking != null) {
      return new ResponseEntity<>(updatedBooking, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteHotelBooking(@PathVariable("id") int hotelBookingId) {
    hotelBookingService.deleteHotelBooking(hotelBookingId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}