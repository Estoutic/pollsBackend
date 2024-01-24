package com.estoutic.pollsbackend.models.poll;


import com.estoutic.pollsbackend.models.category.CategoryDto;
import com.estoutic.pollsbackend.models.poll.fileds.AnswerDto;
import com.estoutic.pollsbackend.models.poll.fileds.QuestionDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PollDto {

    private Boolean state;

    private String categoryId;

    private QuestionDto question;

    private List<AnswerDto> answers;

}
