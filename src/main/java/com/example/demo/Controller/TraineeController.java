package com.example.demo.Controller;

import com.example.demo.DAOandEntity.Trainee.TraineeDAOtoEntity;
import com.example.demo.Service.TraineeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class TraineeController {
    TraineeService traineeService;

    public TraineeController(TraineeService traineeService) {
        this.traineeService = traineeService;
    }

    @GetMapping("/trainees")
    public Object getTrainees () {
        return traineeService.getAllTrainees();
    }

    @PostMapping("/trainees")
    @ResponseStatus(HttpStatus.CREATED)
    public Object addNewTrainee (@RequestBody TraineeDAOtoEntity trainee) {
        return traineeService.addNewTrainee(trainee);
    }

    @DeleteMapping("/trainees/{trainee_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrainee (@PathVariable Long trainee_id) {
        traineeService.deleteTraineeById(trainee_id);
    }
}
