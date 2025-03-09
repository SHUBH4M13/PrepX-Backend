package com.XGroup.PrepX.Backend.Models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Collection;

@Document(collection = "Questions")
public class QuestionModel {

        @Id
        private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public QuestionModel(String id, String examSet, String question, String instructions, String optionA, String optionB, String optionD, String optionC, String correctOption, String explanation) {
        this.id = id;
        this.examSet = examSet;
        this.question = question;
        this.instructions = instructions;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionD = optionD;
        this.optionC = optionC;
        this.correctOption = correctOption;
        this.explanation = explanation;
    }

    public String getExamSet() {
        return examSet;
    }

    public void setExamSet(String examSet) {
        this.examSet = examSet;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(String correctOption) {
        this.correctOption = correctOption;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    @Field("ExamSet") // This should exactly match the DB field name
        private String examSet;

    @Field("Instructions")
    private String instructions;

    @Field("Question")
        private String question;


        private String optionA;


        private String optionB;


        private String optionC;

        private String optionD;

        private String correctOption;
        private String explanation;

        // Getters and Setters
    // Getters & Setters
}

