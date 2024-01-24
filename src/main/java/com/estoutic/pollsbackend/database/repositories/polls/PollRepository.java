package com.estoutic.pollsbackend.database.repositories.polls;

import com.estoutic.pollsbackend.database.entities.polls.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends JpaRepository<Poll, String> {
}
