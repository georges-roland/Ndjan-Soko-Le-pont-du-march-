package com.example.demo.repository;

import com.example.demo.model.TransportTrip;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface TransportTripRepository extends JpaRepository<TransportTrip, UUID> {
}
