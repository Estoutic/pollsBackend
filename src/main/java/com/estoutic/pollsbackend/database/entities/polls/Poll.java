package com.estoutic.pollsbackend.database.entities.polls;

import com.estoutic.pollsbackend.models.poll.PollDto;
import com.estoutic.pollsbackend.models.poll.fileds.QuestionDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
public class Poll {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(length = 64, updatable = false, nullable = false)
    private String id;

    private boolean state;

    @CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime creationUpdateTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    private Question question;

    public Poll(PollDto pollDto,Question question) {
        this.state = pollDto.getState();
        this.question = question;
    }
}