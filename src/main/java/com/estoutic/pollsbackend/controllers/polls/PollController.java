package com.estoutic.pollsbackend.controllers.polls;

import com.estoutic.pollsbackend.models.poll.PollDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/poll")
public class PollController {


    @PostMapping("/create")
    public PollDto createPoll(@RequestBody() PollDto pollDto) {
        return pollDto;
    }
}
