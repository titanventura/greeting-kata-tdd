package org.learn_tdd.greeting_kata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Greeting {

    private static final String LOWER_CASE_GREET_FORMAT = "Hello, %s.";
    private static final String UPPER_CASE_GREET_FORMAT = "HELLO, %s!";
    private static final String NULL_SUBSTITUTE = "my friend";

    public String greet(String... names) {

        names = convertNullNames(names);
        names = convertCommaSeparatedNames(names);
        names = removeQuotesFromNames(names);

        String[] lowerCaseNames = filterLowerCaseNames(names);
        String[] upperCaseNames = filterUpperCaseNames(names);

        StringBuilder result = new StringBuilder();

        if (lowerCaseNames.length > 0)
            result.append(String.format(LOWER_CASE_GREET_FORMAT, greetNames(lowerCaseNames)));

        if (upperCaseNames.length > 0) {
            if (lowerCaseNames.length > 0) result.append(" AND ");

            result.append(String.format(UPPER_CASE_GREET_FORMAT, greetNames(upperCaseNames)));
        }

        return String.valueOf(result);
    }

    private String[] removeQuotesFromNames(String[] names) {
        return Arrays.stream(names).map(name -> {
            if (name.startsWith("\"") && name.endsWith("\"")) {
                return name.substring(1, name.length() - 1);
            }
            return name;
        }).collect(Collectors.toList()).toArray(String[]::new);
    }

    private String[] convertCommaSeparatedNames(String[] names) {
        List<String> nameList = new ArrayList<>();

        for (String name : names) {
            if (name.contains(",") && !(name.startsWith("\"") && name.endsWith("\""))) {
                nameList.addAll(Arrays.stream(name.split(",")).map(String::strip).collect(Collectors.toList()));
            } else {
                nameList.add(name);
            }
        }
        return nameList.toArray(String[]::new);
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
        return Arrays.stream(names).map(name -> name == null ? NULL_SUBSTITUTE : name).toArray(String[]::new);
    }

    private boolean isAllUpperCase(String name) {
        if (name == null) return false;
        return name.chars().allMatch(Character::isUpperCase);
    }
}
