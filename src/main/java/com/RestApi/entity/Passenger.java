package com.RestApi.entity;

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
@Table(name = "Passenger_Details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passenger {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Passenger_id")
	private Integer pid;

	@Column(name = "Passenger_name")
	private String name;

	@Column(name = "Passenger_source")
	private String source;

	@Column(name = "Passenger_destination")
	private String destination;
	
	@Column(name = "Passenger_Jdata")
	private Date journeryDate;

	@Column(name = "Tikcet_Price")
	private Double fare;

	@Column(name = "Train_Number")
	private Integer trainNum;

}
