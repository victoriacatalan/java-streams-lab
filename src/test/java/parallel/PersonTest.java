package parallel;

import org.junit.jupiter.api.RepeatedTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * See the {@link Person} for assignment details
 */
class PersonTest {
    private final List<Person> persons = Arrays.asList(
            new Person("Sara", 20),
            new Person("Sara", 22),
            new Person("Bob", 20),
            new Person("Paula", 32),
            new Person("Paul", 32),
            new Person("Jack", 3),
            new Person("Jack", 72),
            new Person("Jill", 11)
    );

    @RepeatedTest(1000)
    public void checkOrder() {
        List<String> strings = Person.personsOlderThan30(persons);

        assertEquals(Arrays.asList("PAULA", "PAUL", "JACK"), strings);
    }

    @RepeatedTest(1000)
    public void checkContent() {
        List<String> strings = Person.personsOlderThan30(persons);

        assertEquals(new HashSet<>(Arrays.asList("PAULA", "PAUL", "JACK")), new HashSet<>(strings));
    }
}