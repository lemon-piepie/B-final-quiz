package com.example.demo.DAOandEntity.Trainee;

import com.example.demo.Entity.Trainee;
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
public class EntityToDAO {
    private Long id;

    private String name;

    private String office;

    private String email;

    private String github;

    private String zoomId;

    public static EntityToDAO fromEntity(Trainee trainee) {

        return EntityToDAO.builder()
                .id(trainee.getId())
                .name(trainee.getName())
                .github(trainee.getGithub())
                .office(trainee.getOffice())
                .zoomId(trainee.getZoomId())
                .email(trainee.getEmail())
                .build();
    }

    public static List<EntityToDAO> fromEntityList(List<Trainee> trainees) {
        return trainees.stream()
                .map(EntityToDAO::fromEntity)
                .collect(Collectors.toList());
    }
}
