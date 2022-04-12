package org.learn_tdd.greeting_kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetingTest {
    @Test
    void shouldGreetWhenNameIsPassed() {
        Greeting greeting = new Greeting();
        String name = "Bob";
        String expected = "Hello, Bob.";

        String result = greeting.greet(name);

        assertEquals(expected, result);
    }
}
