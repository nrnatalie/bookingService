package de.aittr.g_27_bookingService.domain;

import java.util.Date;

public interface Flights {
  String getDeparture();
  void setDeparture(String departure);
  String getDestination();

  void setDestination(String destination);
  Date getArrivalDate();
  void setArrivalDate(Date arrivalDate);
  Date getDepartureDate();
  void setDepartureDate(Date departureDate);
}
