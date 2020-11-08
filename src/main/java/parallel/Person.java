package parallel;

import java.util.ArrayList;
import java.util.List;

/**
 * The assignment consist of several parts
 *
 * 1. What does the {@link #personsOlderThan30(List)} do?
 * 2. Run the tests for the class to ensure they run green
 * 3. Change {@link #personsOlderThan30(List)} so that it uses a parallel stream instead of a stream
 * 4. Run the tests, they should now fail, why?
 * 5. Update the code in {@link #personsOlderThan30(List)} so that the tests run green
 */
public class Person {private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static List<String> personsOlderThan30(List<Person> persons) {
        List<String> namesOfOlderThan30 = new ArrayList<>();

        persons.stream()
                .filter(person -> person.getAge() > 30)
                .map(Person::getName)
                .map(String::toUpperCase)
                .forEach(namesOfOlderThan30::add);

        return namesOfOlderThan30;
    }
}
