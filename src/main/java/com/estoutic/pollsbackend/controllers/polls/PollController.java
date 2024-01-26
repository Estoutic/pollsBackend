package com.estoutic.pollsbackend.controllers.polls;

import com.estoutic.pollsbackend.models.poll.PollDto;
import com.estoutic.pollsbackend.services.PollService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/category/{id}")
    public List<PollDto> getAllByCategory(@PathVariable(name = "id") String categoryId){
        return pollService.getAllByCategory(categoryId);
    }
}
