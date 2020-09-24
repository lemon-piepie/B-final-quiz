package com.example.demo.DAOandEntity.Trainer;

import com.example.demo.Entity.Trainee;
import com.example.demo.Entity.Trainer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrainerDAOtoEntity {
    private String name;

    public static Trainer toEntity(TrainerDAOtoEntity message) {
        return Trainer.builder()
                .name(message.getName())
                .build();
    }
}
