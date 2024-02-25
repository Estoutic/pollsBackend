package com.estoutic.pollsbackend.models.poll.fileds;

import com.estoutic.pollsbackend.database.entities.polls.Answer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerDto {

    private String pollId;

    private String description;

    private Integer count;

    @JsonCreator
    public AnswerDto(@JsonProperty("description") String description) {
        this.description = description;
    }

    public AnswerDto(Answer answer) {
        this.pollId = answer.getId();
        this.description = answer.getDescription();
        this.count = 30;
    }
}
