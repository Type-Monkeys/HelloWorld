package com.typemonkeys.helloworld.repositories;

import com.typemonkeys.helloworld.Greeting;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GreetingRepository {
    private List<Greeting> greetings = new ArrayList<>();

    public List<Greeting> findAll(){
        return greetings;
    }

    public void save(Greeting greeting){
        greetings.add(greeting);
    }
}
