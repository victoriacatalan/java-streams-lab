
import entities.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BookTest {

    @Test
    void Should_ReturnUniqueTags() {
        List<Book> library = BookFixture.generateLibrary();
        List<String> expected = new ArrayList<>(Arrays.asList("YA", "Fantasy", "Java", "Study Guide", "Drawing"));

        List<String> result = new ArrayList<>();
        for(Book book : library) {
            for (String tag : book.getTags()) {
                if (!result.contains(tag)) {
                    result.add(tag);
                }
            }
        }

        List<String> result2 = library.stream()
                .flatMap(book -> book.getTags().stream())
                .distinct()
                .collect(Collectors.toList());

        Assertions.assertEquals(expected, result2);
    }

    void

}
