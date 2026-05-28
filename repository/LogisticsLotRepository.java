package com.example.demo.repository;

import com.example.demo.model.LogisticsLot;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface LogisticsLotRepository extends JpaRepository<LogisticsLot, UUID> {
}
