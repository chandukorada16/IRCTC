package com.RestApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RestApi.dto.PassenegerDto;
import com.RestApi.entity.Passenger;
import com.RestApi.entity.Ticket;
import com.RestApi.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {

	
	private final TicketService service;
	
	public TicketController(TicketService service) {
		this.service=service;
	}

	@PostMapping(value="/bookTicket",
			produces= {"application/json","application/xml"},
			consumes= {"application/json","application/xml"})
	public ResponseEntity<Ticket> bookTicket(@RequestBody PassenegerDto passenger) {
		Ticket bookTicket = service.bookTicket(passenger);
		System.out.println(passenger);
		
		return new ResponseEntity<Ticket>(bookTicket, HttpStatus.CREATED);
	}

	@GetMapping(value="/getTicket/{ticketId}",
			produces = {"application/xml","application/json"}
	)
	public ResponseEntity<Ticket> getTicket(@PathVariable("ticketId") Integer ticketId) {
		Ticket ticketById = service.getTicket(ticketId);

		return new ResponseEntity<Ticket>(ticketById, HttpStatus.OK);
	}

	@PutMapping("/updateTicket/{ticketId}")
	public ResponseEntity<Ticket> updateTicket(@RequestBody PassenegerDto passenger,
			@PathVariable("ticketId") Integer ticketId) {
		Ticket updateTicket = service.updateTicket(passenger, ticketId);
		System.out.println(updateTicket);
		
		return new ResponseEntity<Ticket>(updateTicket, HttpStatus.OK);

	}

	@DeleteMapping("/deleteTicket/{ticketId}")
	public ResponseEntity<Ticket> deleteTicket(@PathVariable("ticketId") Integer ticketId) {
		Ticket deleteTicket = service.deleteTicket(ticketId);
		
		return new ResponseEntity<Ticket>(deleteTicket, HttpStatus.OK);
	}

	@GetMapping(value="/getAllTickets",
			produces = {"application/xml","application/json"}
	)
	public ResponseEntity<List<Ticket>> getAllTicket() {
		List<Ticket> allTickets = service.getAlltickets();

		return new ResponseEntity<List<Ticket>>(allTickets, HttpStatus.OK);
	}
}
