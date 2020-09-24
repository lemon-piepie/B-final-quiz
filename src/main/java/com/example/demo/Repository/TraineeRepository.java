package com.example.demo.Repository;

import com.example.demo.Entity.Trainee;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EntityScan("com.example.demo.Entity")
public interface TraineeRepository extends JpaRepository<Trainee, Long> {
    Optional<Trainee> findOneById(Long id);
}
