package com.example.demo.DAOandEntity.Trainee;

import com.example.demo.Entity.Trainee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TraineeDAOtoEntity {
    private String name;

    private String office;

    private String email;

    private String github;

    private String zoomId;

    public static Trainee toEntity(TraineeDAOtoEntity message) {
        return Trainee.builder()
                .name(message.getName())
                .github(message.getGithub())
                .office(message.getOffice())
                .zoomId(message.getZoomId())
                .email(message.getEmail())
                .build();
    }
}
