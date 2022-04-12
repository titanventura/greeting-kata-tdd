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

    @Test
    void shouldGreetEvenWhenNameIsNull() {
        Greeting greeting = new Greeting();
        String name = null;
        String expected = "Hello, my friend.";

        String result = greeting.greet(name);

        assertEquals(expected, result);
    }


    @Test
    void shouldHandleShouting() {
        Greeting greeting = new Greeting();
        String name = "JERRY";
        String expected = "HELLO, JERRY!";

        String result = greeting.greet(name);

        assertEquals(expected, result);
    }

    @Test
    void shouldHandleVarArgs() {
        Greeting greeting = new Greeting();
        String john = "John";
        String doe = "Doe";
        String expected = "Hello, John and Doe.";

        String result = greeting.greet(john, doe);

        assertEquals(expected, result);
    }
}
