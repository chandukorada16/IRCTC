package com.RestApi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RestApi.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

}
