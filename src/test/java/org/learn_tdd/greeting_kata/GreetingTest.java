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
    void shouldGreetByShoutingWhenNameIsAllUpperCase() {
        Greeting greeting = new Greeting();
        String name = "JERRY";
        String expected = "HELLO, JERRY!";

        String result = greeting.greet(name);

        assertEquals(expected, result);
    }

    @Test
    void shouldGreetWithAndWhenTwoNamesArePassed() {
        Greeting greeting = new Greeting();
        String john = "John";
        String doe = "Doe";
        String expected = "Hello, John and Doe.";

        String result = greeting.greet(john, doe);

        assertEquals(expected, result);
    }

    @Test
    void shouldGreetWithCommaAndClosingAndWhenMultipleNamesArePassed() {
        Greeting greeting = new Greeting();
        String john = "John";
        String doe = "Doe";
        String jane = "Jane";
        String expected = "Hello, John, Doe, and Jane.";

        String result = greeting.greet(john, doe, jane);

        assertEquals(expected, result);
    }

    @Test
    void shouldGreetSeparatelyWhenMixedTypeOfNamesArePassed() {
        Greeting greeting = new Greeting();
        String amy = "Amy";
        String brian = "BRIAN";
        String charlotte = "Charlotte";
        String expected = "Hello, Amy and Charlotte. AND HELLO, BRIAN!";

        String result = greeting.greet(amy, brian, charlotte);

        assertEquals(expected, result);
    }

    @Test
    void shouldConsiderAsDifferentNamesWhenANameSeparatedByComma() {
        Greeting greeting = new Greeting();
        String amy = "Amy";
        String charlotteAndDianne = "Charlotte, Dianne";
        String expected = "Hello, Amy, Charlotte, and Dianne.";

        String result = greeting.greet(amy, charlotteAndDianne);

        assertEquals(expected, result);
    }

    @Test
    void shouldConsiderCommaSeparatedNameAsSingleWhenEnclosedByQuotes() {
        Greeting greeting = new Greeting();
        String amy = "Amy";
        String charlotteAndDianne = "\"Charlotte, Dianne\"";
        String expected = "Hello, Amy and Charlotte, Dianne.";

        String result = greeting.greet(amy, charlotteAndDianne);

        assertEquals(expected, result);
    }
}
