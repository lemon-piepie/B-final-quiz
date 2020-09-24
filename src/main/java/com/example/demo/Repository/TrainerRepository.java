package com.example.demo.Repository;

import com.example.demo.Entity.Trainer;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EntityScan("com.example.demo.Entity")
public interface TrainerRepository extends JpaRepository<Trainer, Long> {
    Optional<Trainer> findOneById(Long id);
}
