package de.aittr.g_27_bookingService.domain;

import java.util.Date;

public interface HotelBooking {
  String getDestination();
  void setDestination(String destination);

  String getHotelPreference();
  void setHotelPreference(String hotelPreference);

  Date getCheckInDate();
  void setCheckInDate(Date checkInDate);

  Date getCheckOutDate();
  void setCheckOutDate(Date checkOutDate);

  int getAdults();
  void setAdults(int adults);

  int getChildren();
  void setChildren(int children);

  int getRooms();
  void setRooms(int rooms);

  double getTicketPrice();
  void setTicketPrice(double ticketPrice);

  String getPaymentMethod();
  void setPaymentMethod(String paymentMethod);

}
