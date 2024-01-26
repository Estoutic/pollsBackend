package com.estoutic.pollsbackend.models.poll.fileds;

import com.estoutic.pollsbackend.database.entities.polls.Question;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionDto {

    private String questionId;

    @JsonProperty("description")
    private String description;

    @JsonCreator
    public QuestionDto(@JsonProperty("description") String description) {
        this.description = description;
    }

    public QuestionDto(Question question) {
        this.questionId = question.getId();
        this.description = question.getDescription();
    }
}
