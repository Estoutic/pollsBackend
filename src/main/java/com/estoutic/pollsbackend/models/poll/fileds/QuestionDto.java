package com.estoutic.pollsbackend.models.poll.fileds;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionDto {

    @JsonProperty("description")
    private String description;

    @JsonCreator
    public QuestionDto(@JsonProperty("description") String description) {
        this.description = description;
    }

}
