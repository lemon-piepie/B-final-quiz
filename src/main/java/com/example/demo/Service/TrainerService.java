package com.example.demo.Service;


import com.example.demo.DAOandEntity.Trainee.TraineeEntityToDAO;
import com.example.demo.DAOandEntity.Trainer.TrainerDAOtoEntity;
import com.example.demo.DAOandEntity.Trainer.TrainerEntityToDAO;
import com.example.demo.Entity.Trainee;
import com.example.demo.Entity.Trainer;
import com.example.demo.Repository.TrainerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TrainerService {
    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public List<TrainerEntityToDAO> getAllTrainers() {
        List<Trainer> trainerList = trainerRepository.findAll();
        return TrainerEntityToDAO.fromEntityList(trainerList);
    }

    public TrainerEntityToDAO addNewTrainer (TrainerDAOtoEntity newTrainer) {
        Trainer trainer = TrainerDAOtoEntity.toEntity(newTrainer);
        Trainer save = trainerRepository.save(trainer);
        return TrainerEntityToDAO.fromEntity(save);
    }

    public void deleteTrainerById(Long id) {
        if (trainerRepository.findOneById(id).isPresent()) {
            trainerRepository.deleteById(id);
        } else {
            throw new Error("该讲师不存在");
        }
    }
}
