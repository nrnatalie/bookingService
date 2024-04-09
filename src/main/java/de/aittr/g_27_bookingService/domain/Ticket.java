package de.aittr.g_27_bookingService.domain;

import java.util.Date;

public interface Ticket {

  String getType();
  void setType(String type);

  String getDeparture();
  void setDeparture(String departure);

  String getDestination();
  void setDestination(String destination);

  Date getDepartureDate();
  void setDepartureDate(Date departureDate);

  Date getReturnDate();
  void setReturnDate(Date returnDate);

  double getPrice();
  void setPrice(double price);

  String getStatus();
  void setStatus(String status);

  String getPaymentMethod();
  void setPaymentMethod(String paymentMethod);
}
