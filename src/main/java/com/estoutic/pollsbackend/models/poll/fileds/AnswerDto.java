package com.estoutic.pollsbackend.models.poll.fileds;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerDto {

    private String description;

    @JsonCreator
    public AnswerDto(@JsonProperty("description") String description) {
        this.description = description;
    }

}
