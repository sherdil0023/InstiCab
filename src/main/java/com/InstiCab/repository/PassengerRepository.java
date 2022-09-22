package com.InstiCab.repository;

import com.InstiCab.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger,Long> {
    Passenger findByPassengerId(Long id);
}
