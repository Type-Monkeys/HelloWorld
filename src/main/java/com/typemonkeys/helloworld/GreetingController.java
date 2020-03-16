package com.typemonkeys.helloworld;

import com.typemonkeys.helloworld.repositories.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/greetings")
public class GreetingController {

    private GreetingRepository greetingRepository;

    @Autowired
    public GreetingController(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @GetMapping
    public List<Greeting> get() {
        List<Greeting> greetingList = greetingRepository.findAll();
        return greetingList;
    }

    public void post(Greeting helloGreetings) {
        greetingRepository.save(helloGreetings);
    }

    public Greeting get(String id) {
        List<Greeting> repoGreeting = greetingRepository.findAll();
        return repoGreeting.stream()
                .filter(greeting -> greeting.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}