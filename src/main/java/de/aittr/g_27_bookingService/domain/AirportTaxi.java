package de.aittr.g_27_bookingService.domain;

import java.util.Date;

public interface AirportTaxi {
  String getPickupLocation();
  void setPickupLocation(String pickupLocation);
  String getDropoffLocation();
  void setDropoffLocation(String dropoffLocation);
  Date getPickupDateTime();
  void setPickupDateTime(Date pickupDateTime);
  int getPassengerCount();
  void setPassengerCount(int passengerCount);
}
