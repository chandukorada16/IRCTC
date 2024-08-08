package com.RestApi.service;

import java.util.List;

import com.RestApi.dto.PassenegerDto;
import com.RestApi.entity.Ticket;

public interface TicketService {

	public Ticket bookTicket(PassenegerDto passengerInfo);

	public Ticket getTicket(Integer ticketId);

	public Ticket updateTicket(PassenegerDto passenger,Integer ticketId);

	public Ticket deleteTicket(Integer ticketId);

	public List<Ticket> getAlltickets();
}
