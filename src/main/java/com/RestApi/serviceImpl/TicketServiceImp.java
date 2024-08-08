package com.RestApi.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.RestApi.dto.PassenegerDto;
import com.RestApi.entity.Passenger;
import com.RestApi.entity.Ticket;
import com.RestApi.exception.TicketNotFoundException;
import com.RestApi.repo.PassengerRepository;
import com.RestApi.repo.TicketRepository;
import com.RestApi.service.TicketService;

@Service
public class TicketServiceImp implements TicketService {

	private final TicketRepository ticketRepository;

	private final PassengerRepository passengerRepository;
	
	public TicketServiceImp(TicketRepository ticketRepository,PassengerRepository passengerRepository) {
		this.ticketRepository=ticketRepository;
		this.passengerRepository=passengerRepository;
	}


	@Override
	public Ticket bookTicket(PassenegerDto passengerdto) {
		
		Passenger passenger=new Passenger();
		
		  passenger.setName(passengerdto.getName());
		  passenger.setSource(passengerdto.getSource());
		  passenger.setDestination(passengerdto.getDestination());
		  passenger.setJourneryDate(new Date());
		  passenger.setFare(passengerdto.getFare());
		  passenger.setTrainNum(passengerdto.getTrainNum());
		 
//		BeanUtils.copyProperties(passengerdto, passenger);

		Passenger savedPassenger = passengerRepository.save(passenger);
		/*
		 * String pnr = "";
		 * 
		 * for (int i = 0; i <= 8; i++) { pnr = pnr + (int) (Math.random() * 10); }
		 */
		String pnr = new Random().ints(0, 10)
                .limit(9)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());

		Ticket tic = new Ticket();
		
		  tic.setName(savedPassenger.getName());
		  tic.setJourneryDate(savedPassenger.getJourneryDate());
		  tic.setSource(savedPassenger.getSource());
		  tic.setDestination(savedPassenger.getDestination());
		  tic.setJourneryDate(savedPassenger.getJourneryDate());
		  tic.setTicketPnr(pnr);
		  tic.setTicketStatus("confirmed");
		  tic.setTrainNum(savedPassenger.getTrainNum());
		 
		Ticket savedTicket = ticketRepository.save(tic);

		return savedTicket;
	}

	@Override
	public Ticket getTicket(Integer ticketId) {
		/*
		 * Optional<Ticket> findById = ticketRepository.findById(ticketId);
		 * if(findById.isPresent()) { return findById.get(); } else { throw new
		 * TicketNotFoundException("Ticket with ID " + ticketId + " does not Found"); }
		 */
		return ticketRepository.findById(ticketId)
        .orElseThrow(() -> new TicketNotFoundException("Ticket with ID " + ticketId + " does not exist"));

	}

	@Override
	public Ticket updateTicket(PassenegerDto passenger, Integer ticketId) {

		/*
		 * String pnr = ""; for (int i = 0; i<=7;i++) { pnr= pnr+(int)
		 * (Math.random()*10); }
		 */
		String pnr = new Random().ints(0, 10)
                .limit(8)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
		return ticketRepository.findById(ticketId).map(existingTicket -> {
            existingTicket.setTicketStatus("Confirmed");
            existingTicket.setName(passenger.getName());
            existingTicket.setTrainNum(passenger.getTrainNum());
            existingTicket.setTicketPnr(pnr);
            existingTicket.setTicketId(ticketId);
            existingTicket.setDestination(passenger.getDestination());
            existingTicket.setSource(passenger.getSource());
            return ticketRepository.save(existingTicket);
        }).orElseThrow(() -> new TicketNotFoundException("Ticket with ID " + ticketId + " does not exist"));
    }
		/*
		 * Optional<Ticket> optionalTicket = ticketRepository.findById(ticketId);
		 * if(optionalTicket.isPresent()) { Ticket existingTicket =
		 * optionalTicket.get(); existingTicket.setTicketStatus("Confirmed");
		 * existingTicket.setName(passenger.getName());
		 * existingTicket.setTrainNum(passenger.getTrainNum());
		 * existingTicket.setTicketPnr(pnr); existingTicket.setTicketId(ticketId);
		 * existingTicket.setDestination(passenger.getDestination());
		 * existingTicket.setSource(passenger.getSource());
		 * ticketRepository.save(existingTicket); return existingTicket; }else { throw
		 * new TicketNotFoundException("Ticket with ID " + ticketId +
		 * " does not exist"); }
		 */

	

	@Override
	public Ticket deleteTicket(Integer ticketId) {

		/*
		 * Optional<Ticket> ticket = ticketRepository.findById(ticketId); if
		 * (ticket.isPresent()) { ticketRepository.deleteById(ticketId); return
		 * ticket.get(); } else { throw new TicketNotFoundException("Ticket with ID " +
		 * ticketId + " does not exist"); }
		 */
		return ticketRepository.findById(ticketId)
                .map(ticket -> {
                    ticketRepository.deleteById(ticketId);
                    return ticket;
                })
                .orElseThrow(() -> new TicketNotFoundException("Ticket with ID " + ticketId + " does not exist"));
    
	}

	@Override
	public List<Ticket> getAlltickets() {

		return ticketRepository.findAll();
	}

}

