package de.aittr.g_27_bookingService.domain;

import java.util.Date;

public interface CarRentals {
  String getLocation();
  void setLocation(String location);
  Date getPickupDate();
  void setPickupDate(Date pickupDate);
  String getPickupTime();
  void setPickupTime(String pickupTime);
  Date getReturnDate();
  void setReturnDate(Date returnDate);
  String getReturnTime();
  void setReturnTime(String returnTime);
}
