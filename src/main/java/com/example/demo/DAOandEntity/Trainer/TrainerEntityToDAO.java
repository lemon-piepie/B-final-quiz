package com.example.demo.DAOandEntity.Trainer;

import com.example.demo.Entity.Trainer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrainerEntityToDAO {
    private Long id;

    private String name;

    public static TrainerEntityToDAO fromEntity(Trainer trainer) {

        return TrainerEntityToDAO.builder()
                .id(trainer.getId())
                .name(trainer.getName())
                .build();
    }

    public static List<TrainerEntityToDAO> fromEntityList(List<Trainer> trainers) {
        return trainers.stream()
                .map(TrainerEntityToDAO::fromEntity)
                .collect(Collectors.toList());
    }
}
