package com.estoutic.pollsbackend.database.repositories.polls;

import com.estoutic.pollsbackend.database.entities.polls.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, String> {
}
