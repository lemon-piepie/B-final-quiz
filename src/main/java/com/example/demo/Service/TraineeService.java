package com.example.demo.Service;

import com.example.demo.DAOandEntity.Trainee.DAOtoEntity;
import com.example.demo.DAOandEntity.Trainee.EntityToDAO;
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
    public List<EntityToDAO> getAllTrainees() {
        List<Trainee> traineeList = traineeRepository.findAll();
        return EntityToDAO.fromEntityList(traineeList);
    }

    public EntityToDAO addNewTrainee(DAOtoEntity message) {
        Trainee trainee = DAOtoEntity.toEntity(message);
        Trainee save = traineeRepository.save(trainee);
        return EntityToDAO.fromEntity(save);
    }

    public void deleteTraineeById(Long id) {
        if (traineeRepository.findOneById(id).isPresent()) {
            traineeRepository.deleteById(id);
        } else {
            throw new Error("该用户不存在");
        }
    }
}
