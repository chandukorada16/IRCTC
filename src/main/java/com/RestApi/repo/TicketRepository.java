package com.RestApi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RestApi.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
