package com.estoutic.pollsbackend.services.impl;

import com.estoutic.pollsbackend.database.entities.Category;
import com.estoutic.pollsbackend.database.entities.polls.Answer;
import com.estoutic.pollsbackend.database.entities.polls.Poll;
import com.estoutic.pollsbackend.database.entities.polls.Question;
import com.estoutic.pollsbackend.database.repositories.CategoryRepository;
import com.estoutic.pollsbackend.database.repositories.polls.AnswerRepository;
import com.estoutic.pollsbackend.database.repositories.polls.PollRepository;
import com.estoutic.pollsbackend.database.repositories.polls.QuestionRepository;
import com.estoutic.pollsbackend.models.poll.PollDto;
import com.estoutic.pollsbackend.services.PollService;
import com.estoutic.pollsbackend.services.exceptions.category.CategoryDoesNotExistException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollServiceImpl implements PollService {

    private final PollRepository pollRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final CategoryRepository categoryRepository;

    public PollServiceImpl(PollRepository pollRepository, QuestionRepository questionRepository, AnswerRepository answerRepository, CategoryRepository categoryRepository) {
        this.pollRepository = pollRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public String save(PollDto pollDto) {

        Category category = categoryRepository.findById(pollDto.getCategoryId()).orElseThrow(CategoryDoesNotExistException::new);
        Question question = new Question(pollDto.getQuestion());
        List<Answer> answers = pollDto.getAnswers().stream().map(answerDto -> new Answer(answerDto, question)).toList();
        Poll poll = new Poll(pollDto, question, category);

        questionRepository.save(question);
        answerRepository.saveAll(answers);
        pollRepository.save(poll).getId();
        categoryRepository.save(category);
        return poll.getId();
    }

    @Override
    public List<PollDto> getAllPolls() {
        return pollRepository.findAll().stream().map(PollDto::new).toList();
    }
}
