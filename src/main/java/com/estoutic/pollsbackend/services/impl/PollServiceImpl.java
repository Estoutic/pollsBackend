package com.estoutic.pollsbackend.services.impl;

import com.estoutic.pollsbackend.database.entities.polls.Answer;
import com.estoutic.pollsbackend.database.entities.polls.Poll;
import com.estoutic.pollsbackend.database.entities.polls.Question;
import com.estoutic.pollsbackend.database.repositories.polls.AnswerRepository;
import com.estoutic.pollsbackend.database.repositories.polls.PollRepository;
import com.estoutic.pollsbackend.database.repositories.polls.QuestionRepository;
import com.estoutic.pollsbackend.models.poll.PollDto;
import com.estoutic.pollsbackend.services.PollService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollServiceImpl implements PollService {

    private final PollRepository pollRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public PollServiceImpl(PollRepository pollRepository, QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.pollRepository = pollRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    @Override
    public String save(PollDto pollDto) {
        Question question = new Question(pollDto.getQuestion());
        List<Answer> answers = pollDto.getAnswers().stream().map(answerDto -> new Answer(answerDto, question)).toList();
        Poll poll = new Poll(pollDto, question);
        
        questionRepository.save(question);
        answerRepository.saveAll(answers);
        return pollRepository.save(poll).getId();

    }
}
