package com.estoutic.pollsbackend.database.entities.polls;

import com.estoutic.pollsbackend.models.poll.fileds.QuestionDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Answer {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(length = 64, updatable = false, nullable = false)
    private String id;

    private String description;

    @ManyToOne
    @JoinColumn(name="question_id", nullable=false)
    private Question question;

    public Answer(QuestionDto questionDto) {
        this.description = questionDto.getDescription();
    }
}