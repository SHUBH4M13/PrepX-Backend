package com.XGroup.PrepX.Backend.Controller;

import com.XGroup.PrepX.Backend.Models.QuestionModel;
import com.XGroup.PrepX.Backend.Repo.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class QuestionController {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @GetMapping("/{examCode}")
    public List<QuestionModel> ues(@PathVariable String examCode) {
        return questionRepository.findByexamCode(examCode);
    }

}