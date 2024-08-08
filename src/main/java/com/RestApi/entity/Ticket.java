package com.RestApi.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Tikcet_details")
public class Ticket {

	@Id
	@Column(name = "Ticket_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ticketId;

	@Column(name = "Passenger_name")
	private String name;

	@Column(name = "Passenger_source")
	private String source;

	@Column(name = "Passenger_destination")
	private String destination;
	
	@Column(name = "Passenger_Jdata")
	private Date journeryDate;
	
	@Column(name = "Trian_Num")
	private Integer trainNum;

	@Column(name = "Ticket_Pnr")
	private String ticketPnr;

	@Column(name = "Ticket_Status")
	private String ticketStatus;

}
