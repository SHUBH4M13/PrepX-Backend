package com.XGroup.PrepX.Backend.Repo;

import com.XGroup.PrepX.Backend.Models.QuestionModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends MongoRepository<QuestionModel, String> {
    List<QuestionModel> findByExamSet(String ExamSet);
}

