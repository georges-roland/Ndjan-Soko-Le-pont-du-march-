package com.example.demo.repository;

import com.example.demo.model.EscrowTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface EscrowTransactionRepository extends JpaRepository<EscrowTransaction, UUID> {
    // Utile pour le système de hachage SHA-256 : trouver la dernière transaction
    Optional<EscrowTransaction> findFirstByOrderByIdDesc();
}
