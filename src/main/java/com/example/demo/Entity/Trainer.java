package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    //TODO GTB：不需要特别命名
    @JsonProperty("trainerId")
    private Long id;
    private String name;
}
