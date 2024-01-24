package com.estoutic.pollsbackend.services;

import com.estoutic.pollsbackend.models.poll.PollDto;

public interface PollService {

    String save(PollDto pollDto);
}
