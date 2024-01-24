package com.estoutic.pollsbackend.database.entities.polls;

import com.estoutic.pollsbackend.models.poll.fileds.AnswerDto;
import com.estoutic.pollsbackend.models.poll.fileds.QuestionDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
public class Question {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(length = 64, updatable = false, nullable = false)
    private String id;

    private String description;

    @OneToOne(mappedBy = "question")
    private Poll user;

    @OneToMany(mappedBy="question")
    private Set<Answer> answers;


    public Question(QuestionDto questionDto, List<Answer> answerDtoList) {
        this.description = questionDto.getDescription();
        answers.addAll(answerDtoList);
    }
}