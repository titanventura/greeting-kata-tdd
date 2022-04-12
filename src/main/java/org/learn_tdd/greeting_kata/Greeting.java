package org.learn_tdd.greeting_kata;

public class Greeting {
    public String greet(String name) {

        name = name == null ? "my friend" : name;

        return String.format("Hello, %s.", name);
    }
}
