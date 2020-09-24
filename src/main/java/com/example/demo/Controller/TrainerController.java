package com.example.demo.Controller;

import com.example.demo.DAOandEntity.Trainer.TrainerDAOtoEntity;
import com.example.demo.Service.TrainerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class TrainerController {
    TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping("/trainers")
    public Object getTrainers () {
        return trainerService.getAllTrainers();
    }

    @PostMapping("/trainers")
    @ResponseStatus(HttpStatus.CREATED)
    public Object addNewTrainer (@RequestBody TrainerDAOtoEntity trainer) {
        return trainerService.addNewTrainer(trainer);
    }

    @DeleteMapping("/trainers/{trainer_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrainer (@PathVariable Long trainer_id) {
        trainerService.deleteTrainerById(trainer_id);
    }
}
