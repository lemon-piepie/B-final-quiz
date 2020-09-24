package com.example.demo.Service;

import com.example.demo.DAOandEntity.Trainee.TraineeDAOtoEntity;
import com.example.demo.DAOandEntity.Trainee.TraineeEntityToDAO;
import com.example.demo.Entity.Trainee;
import com.example.demo.Repository.TraineeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TraineeService {
    private final TraineeRepository traineeRepository;

    public TraineeService(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;
    }
    public List<TraineeEntityToDAO> getAllTrainees() {
        List<Trainee> traineeList = traineeRepository.findAll();
        return TraineeEntityToDAO.fromEntityList(traineeList);
    }

    public TraineeEntityToDAO addNewTrainee(TraineeDAOtoEntity message) {
        Trainee trainee = TraineeDAOtoEntity.toEntity(message);
        Trainee save = traineeRepository.save(trainee);
        return TraineeEntityToDAO.fromEntity(save);
    }

    public void deleteTraineeById(Long id) {
        if (traineeRepository.findOneById(id).isPresent()) {
            traineeRepository.deleteById(id);
        } else {
            throw new Error("该用户不存在");
        }
    }
}
