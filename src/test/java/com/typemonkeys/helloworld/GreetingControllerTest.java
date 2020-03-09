package com.typemonkeys.helloworld;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GreetingControllerTest {
    @Test
    void get_shouldReturnHello_whenCalled() {
        // Arrange
        GreetingController controller = new GreetingController();

        // Act
        String result = controller.get();

        // Assert
        assertEquals("Hello World", result);
    }

    @ParameterizedTest
    @CsvSource({"Blake, Hello Blake","Germ, Hello Germ"})
    void get_shouldReturnGreetingWithAName_whenCalledWithAName(String name, String expected) {
        // Arrange
        GreetingController controller = new GreetingController();

        // Act
        String result = controller.get(name);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void get_shouldReturnHelloWorld_whenCalledWithAnEmptyString() {
        // Arrange
        GreetingController controller = new GreetingController();

        // Act
        String result = controller.get("");

        // Assert
        assertEquals("Hello World", result);
    }


    @ParameterizedTest
    @CsvSource(value = {"1;Hello", "2;Hello,Hello", "3;Hello,Hello,Hello"}, delimiter = ';')
    void get_shouldReturnMultipleGreeting_whenCalledWithANumber(int repetitions, String expected) {
        // Arrange
        GreetingController controller = new GreetingController();

        // Act
        String result = controller.get(repetitions);

        // Assert
        assertEquals(expected, result);
    }
}