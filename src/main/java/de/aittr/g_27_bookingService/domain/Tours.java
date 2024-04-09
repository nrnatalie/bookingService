package de.aittr.g_27_bookingService.domain;

import java.util.Date;

public interface Tours {

  String getDestination();
  void setDestination(String destination);
  Date getStartDate();
  void setStartDate(Date startDate);
  Date getEndDate();
  void setEndDate(Date endDate);
}
