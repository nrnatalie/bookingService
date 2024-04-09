package de.aittr.g_27_bookingService.domain;

import java.util.Date;
import java.util.Objects;

public class HotelBookingDto {

  private String destination;
  private String hotelPreference;
  private Date checkInDate;
  private Date checkOutDate;
  private int adults;
  private int children;
  private int rooms;
  private double ticketPrice;
  private String paymentMethod;

  public HotelBookingDto() {

  }


  public HotelBookingDto(String destination, String hotelPreference, Date checkInDate,
      Date checkOutDate, int adults, int children, int rooms, double ticketPrice,
      String paymentMethod) {
    this.destination = destination;
    this.hotelPreference = hotelPreference;
    this.checkInDate = checkInDate;
    this.checkOutDate = checkOutDate;
    this.adults = adults;
    this.children = children;
    this.rooms = rooms;
    this.ticketPrice = ticketPrice;
    this.paymentMethod = paymentMethod;
  }


  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public String getHotelPreference() {
    return hotelPreference;
  }

  public void setHotelPreference(String hotelPreference) {
    this.hotelPreference = hotelPreference;
  }

  public Date getCheckInDate() {
    return checkInDate;
  }

  public void setCheckInDate(Date checkInDate) {
    this.checkInDate = checkInDate;
  }

  public Date getCheckOutDate() {
    return checkOutDate;
  }

  public void setCheckOutDate(Date checkOutDate) {
    this.checkOutDate = checkOutDate;
  }

  public int getAdults() {
    return adults;
  }

  public void setAdults(int adults) {
    this.adults = adults;
  }

  public int getChildren() {
    return children;
  }

  public void setChildren(int children) {
    this.children = children;
  }

  public int getRooms() {
    return rooms;
  }

  public void setRooms(int rooms) {
    this.rooms = rooms;
  }

  public double getTicketPrice() {
    return ticketPrice;
  }

  public void setTicketPrice(double ticketPrice) {
    this.ticketPrice = ticketPrice;
  }

  public String getPaymentMethod() {
    return paymentMethod;
  }

  public void setPaymentMethod(String paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HotelBookingDto that = (HotelBookingDto) o;
    return adults == that.adults && children == that.children && rooms == that.rooms
        && Double.compare(that.ticketPrice, ticketPrice) == 0 && Objects.equals(
        destination, that.destination) && Objects.equals(hotelPreference,
        that.hotelPreference) && Objects.equals(checkInDate, that.checkInDate)
        && Objects.equals(checkOutDate, that.checkOutDate) && Objects.equals(
        paymentMethod, that.paymentMethod);
  }

  @Override
  public String toString() {
    return "HotelBookingDto{" +
        "destination='" + destination + '\'' +
        ", hotelPreference='" + hotelPreference + '\'' +
        ", checkInDate=" + checkInDate +
        ", checkOutDate=" + checkOutDate +
        ", adults=" + adults +
        ", children=" + children +
        ", rooms=" + rooms +
        ", ticketPrice=" + ticketPrice +
        ", paymentMethod='" + paymentMethod + '\'' +
        '}';
  }

  @Override
  public int hashCode() {
    return Objects.hash(destination, hotelPreference, checkInDate, checkOutDate, adults, children,
        rooms, ticketPrice, paymentMethod);
  }
}
