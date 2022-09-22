package com.InstiCab.repository;

import com.InstiCab.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
    Vehicle findByVehicleId(Long id);
}
