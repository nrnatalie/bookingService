package de.aittr.g_27_bookingService.domain;

import java.util.List;

public interface Cart {
  List<Ticket> getTickets();
  void setTickets(List<Ticket> tickets);

  void addTicket(Ticket ticket);

  void deleteTicketById(int ticketId);

  void clear();

  double getTotalPrice();

  double getAveragePrice();
}
