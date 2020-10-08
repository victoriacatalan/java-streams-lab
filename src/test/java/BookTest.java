
import entities.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BookTest {

    private List<Book> library;


    @BeforeEach
    void SetUp() {
        library = BookFixture.generateLibrary();
    }

    @Test
    void Should_ReturnUniqueTags() {
        List<String> expected = Arrays.asList("YA", "Fantasy", "Java", "Study Guide", "Drawing");
        List<String> actual = new ArrayList<>();
        for(Book book : library) {
            for (String tag : book.getTags()) {
                if (!actual.contains(tag)) {
                    actual.add(tag);
                }
            }
        }

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void Should_ReturnPriceOfAllFantasy() {
        int expected = 248;
        int actual = 1;

        //TODO: Repleace actual with stream

        Assertions.assertEquals(expected, actual);

    }


    @Test
    void Should_ReturnAllBooksByTolkien() {
        List<Book> expected = Arrays.asList(BookFixture.getSilmarillon(), BookFixture.getLotr());
        int expectedPrice = 246;

        List<Book> actual = null;
        int actualPrice = 1;

        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(expectedPrice, actualPrice);
    }


    @Test
    void Should_ReturnTwoMostExpensiveBooks() {
        List<Book> expected = List.of(BookFixture.getOCP(), BookFixture.getInk());
        int expectedPrice = 667;

        List<Book> actual = null;
        int actualPrice = 1;

        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(expectedPrice, actualPrice);
    }

    @Test
    void Should_ReturnStatistics() {
        library.stream()
                .mapToInt(Book::getPrice)
                .sum();
    }
}
