package com.typemonkeys.helloworld;

import com.typemonkeys.helloworld.repositories.GreetingRepository;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GreetingControllerTest {
    @ParameterizedTest
    @CsvSource(value = {", man.", ", and stuff", ", ya dolt"}, delimiter = ';')
    void get_shouldReturnHello_whenCalled(String suffix) {
        // Arrange
        GreetingRepository greetingRepository = new GreetingRepository();
        Greeting greetingOne = new Greeting("1", "Hello World" + suffix);
        Greeting greetingTwo = new Greeting("2", "Howdy World" + suffix);
        greetingRepository.save(greetingOne);
        greetingRepository.save(greetingTwo);
        GreetingController controller = new GreetingController(greetingRepository);
        List<Greeting> expected = asList(greetingOne, greetingTwo);

        // Act
        var result = controller.get();

        // Assert
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource(value = {", man.", ", and stuff", ", ya dolt"}, delimiter = ';')
    void post_shouldSaveGreeting_whenCalled(String suffix) {
        // Arrange
        GreetingRepository greetingRepository = new GreetingRepository();
        GreetingController controller = new GreetingController(greetingRepository);

        Greeting greeting = new Greeting("1", "Hello World" + suffix);
        List<Greeting> expected = singletonList(greeting);

        // Act
        controller.post(greeting);

        // Assert
        assertEquals(expected, greetingRepository.findAll());
    }

    @ParameterizedTest
    @CsvSource(value = {"1", "2", "3"})
    void get_shouldReturnGreeting_whenCalledWithAnId(String id) {
        // Arrange
        GreetingRepository greetingRepository = new GreetingRepository();
        Greeting expected = new Greeting(id, "Hello World");
        Greeting notExpected = new Greeting("not " + id, "Hello World");
        greetingRepository.save(expected);
        greetingRepository.save(notExpected);
        GreetingController controller = new GreetingController(greetingRepository);

        // Act
        var result = controller.get(id);

        // Assert
        assertEquals(expected, result);
    }
}