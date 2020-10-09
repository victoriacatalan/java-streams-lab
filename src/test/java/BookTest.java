
import entities.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
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

        //TODO: Replace for loop with stream
        List<String> actual = new ArrayList<>();
        for (Book book : library) {
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
        int expected = 327;

        //TODO: Replace for loop with stream
        int actual = 0;
        for (Book book : library) {
            if (book.getTags().contains("Fantasy")) {
                actual += book.getPrice();
            }
        }

        Assertions.assertEquals(expected, actual);
    }


    @Test
    void Should_ReturnAllBooksByTolkien() {
        List<Book> expected = Arrays.asList(BookFixture.getLotr(), BookFixture.getSilmarillon());
        int expectedPrice = 248;

        //TODO: Replace for loop with stream
        List<Book> actual = new ArrayList<>();
        int actualPrice = 0;
        for (Book book : library) {
            if (book.getAuthor().contains("J. R. R. Tolkien")) {
                actual.add(book);
                actualPrice += book.getPrice();
            }
        }

        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(expectedPrice, actualPrice);
    }

    @Test
    void Should_ReturnMostExpensiveBooks() {
        Book expected = BookFixture.getOCP();

        //TODO: Replace for loop with stream
        Book actual = library.get(0);
        for (Book book : library) {
            if (actual.getPrice() < book.getPrice()) {
                actual = book;
            }
        }

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void Should_ReturnTwoMostExpensiveBooks() {
        List<Book> expected = List.of(BookFixture.getOCP(), BookFixture.getInk());
        int expectedPrice = 667;

        //TODO: Replace with stream
        List<Book> actual = expected;

        int max = 0;
        int secondMax = 0;
        for (Book book : library) {
            int value = book.getPrice();
            if (value > max) {
                int tmp = max;
                max = value;
                secondMax = tmp;
            } else if (value > secondMax) {
                secondMax = value;
            }
        }
        int actualPrice = max + secondMax;

        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(expectedPrice, actualPrice);
    }


    @Test
    void Should_ReturnFirstStudyGuid() {
        Book expected = BookFixture.getInk();

        //TODO: Replace for loop with stream
        Book actual = library.get(0);
        for (Book book : library) {
            for (String tag : book.getTags()) {
                if (tag.equals("Study Guide")) {
                    actual = book;
                    break;
                }
            }
        }

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void Should_GroupBooksByAuthor() {
        Map<String, List<Book>> expected = BookFixture.mapByAuthor();

        //TODO: Replace for loop with stream
        Map<String, List<Book>> actual = new HashMap<>();
        for (Book book : library) {
            if (actual.containsKey(book.getAuthor())) {
                actual.get(book.getAuthor()).add(book);
            } else {
                ArrayList<Book> books = new ArrayList<>();
                books.add(book);
                actual.put(book.getAuthor(), books);
            }
        }

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void Should_GroupBooksByTags() {
        Map<String, List<Book>> expected = BookFixture.mapByTag();

        //TODO: Replace with stream
        Map<String, List<Book>> actual = new HashMap<>();
        for (Book book : library) {
            for (String tag : book.getTags()) {
                if (actual.containsKey(tag)) {
                    actual.get(tag).add(book);
                } else {
                    ArrayList<Book> books = new ArrayList<>();
                    books.add(book);
                    actual.put(tag, books);
                }
            }
        }

        Assertions.assertEquals(expected, actual);
    }

}
