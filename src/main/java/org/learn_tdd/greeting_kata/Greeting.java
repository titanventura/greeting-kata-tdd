package org.learn_tdd.greeting_kata;

public class Greeting {
    public String greet(String... names) {

        if (names.length > 1) {
            if (names.length == 2)
                return greetTwoNames(names);
            return greetNames(names);
        }

        String name = names[0];

        if (isAllUpperCase(name)) return upperCaseGreet(name);

        name = name == null ? "my friend" : name;

        return String.format("Hello, %s.", name);
    }

    private String greetNames(String[] names) {

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < names.length; i++) {
            if (i == names.length - 1)
                builder.append(String.format("and %s", names[i]));
            else
                builder.append(String.format("%s, ", names[i]));
        }

        return String.format("Hello, %s.", builder);
    }

    private String greetTwoNames(String[] names) {

        String name1 = names[0];
        String name2 = names[1];

        return String.format("Hello, %s and %s.", name1, name2);
    }

    private String upperCaseGreet(String name) {
        return String.format("HELLO, %s!", name);
    }

    private boolean isAllUpperCase(String name) {
        if (name == null) return false;
        return name.chars().allMatch(Character::isUpperCase);
    }
}
