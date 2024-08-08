package com.RestApi.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class PassenegerDto {
	
	private String name;
	
	private String source;
	
	private String destination;
	
	private Date journeyDate;
	
	private Double fare;
	
	private Integer trainNum;

}
