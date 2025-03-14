package com.XGroup.PrepX.Backend.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Questions")
public class QuestionModel {

    @Id
    private String id;

    @Field("Examcode")
    private String examCode;

    @Field("Instructions")
    private String instructions;
    @Field("Question")
    private String question;
    @Field("OptionA")
    private String optionA;
    @Field("OptionB")
    private String optionB;
    @Field("OptionC")
    private String optionC;
    @Field("OptionD")
    private String optionD;
    @Field("CorrectAns")
    private String correctAns;
    @Field("Explanation")
    private String explanation;


    // Constructor
    public QuestionModel(String examCode, String instructions, String question,
                         String optionA, String optionB, String optionC, String optionD,
                         String correctAns, String explanation) {
        this.examCode = examCode;
        this.instructions = instructions;
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctAns = correctAns;
        this.explanation = explanation;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExamCode() {
        return examCode;
    }

    public void setExamCode(String examCode) {
        this.examCode = examCode;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
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

    public String getCorrectAns() {
        return correctAns;
    }

    public void setCorrectAns(String correctAns) {
        this.correctAns = correctAns;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    // toString() Method
    @Override
    public String toString() {
        return "QuestionModel{" +
                "id='" + id + '\'' +
                ", examCode='" + examCode + '\'' +
                ", instructions='" + instructions + '\'' +
                ", question='" + question + '\'' +
                ", optionA='" + optionA + '\'' +
                ", optionB='" + optionB + '\'' +
                ", optionC='" + optionC + '\'' +
                ", optionD='" + optionD + '\'' +
                ", correctAns='" + correctAns + '\'' +
                ", explanation='" + explanation + '\'' +
                '}';
    }
}
