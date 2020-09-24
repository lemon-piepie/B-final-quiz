package com.example.demo.Entity;

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
    private Long id;
    private String name;
}
