package org.learn_tdd.greeting_kata;

import java.util.Arrays;

public class Greeting {

    private static final String LOWER_CASE_GREET_FORMAT = "Hello, %s.";
    private static final String UPPER_CASE_GREET_FORMAT = "HELLO, %s!";


    public String greet(String... names) {

        names = convertNullNames(names);

        StringBuilder result = new StringBuilder();

        String[] lowerCaseNames = filterLowerCaseNames(names);
        String[] upperCaseNames = filterUpperCaseNames(names);

        if (lowerCaseNames.length > 0)
            result.append(String.format(LOWER_CASE_GREET_FORMAT, greetNames(lowerCaseNames)));

        if (upperCaseNames.length > 0) {
            if (lowerCaseNames.length > 0) result.append(" AND ");

            result.append(String.format(UPPER_CASE_GREET_FORMAT, greetNames(upperCaseNames)));
        }

        return String.valueOf(result);
    }


    private String greetNames(String[] names) {
        if (names.length == 1) {
            return names[0];
        }

        if (names.length == 2) {
            String twoNameFormat = "%s and %s";
            return String.format(twoNameFormat, names[0], names[1]);
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < names.length; i++) {
            if (i == names.length - 1) result.append(String.format("and %s", names[i]));
            else result.append(String.format("%s, ", names[i]));
        }

        return String.valueOf(result);
    }


    private String[] filterUpperCaseNames(String[] names) {
        return Arrays.stream(names).filter(this::isAllUpperCase).toArray(String[]::new);
    }

    private String[] filterLowerCaseNames(String[] names) {
        return Arrays.stream(names).filter(name -> !isAllUpperCase(name)).toArray(String[]::new);
    }

    private String[] convertNullNames(String[] names) {
        return Arrays.stream(names).map(name -> name == null ? "my friend" : name).toArray(String[]::new);
    }

    private boolean isAllUpperCase(String name) {
        if (name == null) return false;
        return name.chars().allMatch(Character::isUpperCase);
    }
}
