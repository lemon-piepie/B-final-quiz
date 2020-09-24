package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Trainee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("traineeId")
    private Long id;
    private String name;
    private String office;
    private String email;
    private String github;
    private String zoomId;

}
