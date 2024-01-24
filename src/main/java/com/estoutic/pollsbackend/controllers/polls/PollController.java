package com.estoutic.pollsbackend.controllers.polls;

import com.estoutic.pollsbackend.models.poll.PollDto;
import com.estoutic.pollsbackend.services.PollService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/poll")
public class PollController {

    private final PollService pollService;

    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    @PostMapping("/create")
    public String createPoll(@RequestBody() PollDto pollDto) {
        return pollService.save(pollDto);
    }
}
