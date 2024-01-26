package com.estoutic.pollsbackend.models.poll;


import com.estoutic.pollsbackend.database.entities.polls.Poll;
import com.estoutic.pollsbackend.models.category.CategoryDto;
import com.estoutic.pollsbackend.models.poll.fileds.AnswerDto;
import com.estoutic.pollsbackend.models.poll.fileds.QuestionDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Pool;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PollDto {

    private String pollId;

    private Boolean state;

    private String categoryId;

    private QuestionDto question;

    private List<AnswerDto> answers;


    public PollDto(Poll poll) {
        this.pollId = poll.getId();
        this.state = poll.getState();
        this.question = new QuestionDto(poll.getQuestion());
        this.answers = poll.getQuestion().getAnswers().stream().map(AnswerDto::new).toList();

    }
}
