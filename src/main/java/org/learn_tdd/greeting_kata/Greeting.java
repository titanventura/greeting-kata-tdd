package org.learn_tdd.greeting_kata;

public class Greeting {
    public String greet(String name) {

        if (isAllUpperCase(name)) return upperCaseGreet(name);

        name = name == null ? "my friend" : name;

        return String.format("Hello, %s.", name);
    }

    private String upperCaseGreet(String name) {
        return String.format("HELLO, %s!", name);
    }

    private boolean isAllUpperCase(String name) {
        if (name == null) return false;
        return name.chars().allMatch(c -> Character.isUpperCase(c));
    }
}
