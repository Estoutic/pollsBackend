package com.estoutic.pollsbackend.services;

import com.estoutic.pollsbackend.models.poll.PollDto;

import java.util.List;

public interface PollService {

    String save(PollDto pollDto);

    List<PollDto> getAllByCategory(String categoryId);
}
