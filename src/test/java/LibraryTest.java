import entities.Book;
import entities.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library(BookFixture.generateLibrary());
    }

    @Test
    void Should_ReturnAllBooksByTolkien_When_GetAllBooksByAuthor() {
        List<Book> expected = Arrays.asList(BookFixture.getLotr(), BookFixture.getSilmarillon());
        List<Book> actual = library.getAllBooksByAuthor("J. R. R. Tolkien");
        assertEquals(expected, actual);
    }

    @Test
    void Should_ReturnMostExpensiveBook_When_GetMostExpensiveBook() {
        Book expected = BookFixture.getOCP();
        Book actual = library.getMostExpensiveBook();
        assertEquals(expected, actual);
    }

    @Test
    void Should_ReturnPriceOfAllFantasy_When_GetTotalPriceByTag() {
        int expected = 327;
        int actual = library.getTotalPriceByTag("Fantasy");
        assertEquals(expected, actual);
    }

    @Test
    void Should_ReturnFirstStudyGuide_When_GetAnyBookByTag() {
        List<Book> expected = Arrays.asList(BookFixture.getInk(), BookFixture.getOCP());
        Book actual = library.getAnyBookByTag("Study Guide").orElse(null);
        assertTrue(expected.contains(actual));
    }

    @Test
    void Should_ReturnTrue_When_HasBooksInLibrary() {
        boolean actual = library.hasBooksInLibrary("J. R. R. Tolkien");
        assertTrue(actual);
    }

    @Test
    void Should_ReturnTrue_When_AreAllBooksInTagWrittenByAuthorWithTagUnknown() {
        boolean actual = library.areAllBooksInTagWrittenByAuthor("Unknown", "Alphonso Dunn");
        assertTrue(actual);
    }

    @Test
    void Should_ReturnFalse_When_AreAllBooksInTagWrittenByAuthorWithTagStudyGuide() {
        boolean actual = library.areAllBooksInTagWrittenByAuthor("Study Guide", "Alphonso Dunn");
        assertFalse(actual);
    }

    @Test
    void Should_ReturnTrue_When_AreAllBooksInTagWrittenByAuthorWithTagDrawing() {
        boolean actual = library.areAllBooksInTagWrittenByAuthor("Drawing", "Alphonso Dunn");
        assertTrue(actual);
    }

    @Test
    void Should_ReturnAllUniqueTags_When_GetAllUniqueTags() {
        List<String> expected = Arrays.asList("YA", "Fantasy", "Java", "Study Guide", "Drawing");
        List<String> actual = library.getDistinctTags();
        assertEquals(expected, actual);
    }

    @Test
    void Should_ReturnAuthorMap_When_GroupBooksByAuthor() {
        Map<String, List<Book>> expected = BookFixture.mapByAuthor();
        Map<String, List<Book>> actual = library.groupBooksByAuthor();
        assertEquals(expected, actual);
    }

    @Test
    void Should_ReturnTopTwoRatedBooks_When_GetTopRatedBooks() {
        List<Book> expected = List.of(BookFixture.getLotr(), BookFixture.getInk());
        List<Book> actual = library.getTopRatedBooks();
        assertEquals(expected, actual);
    }

    @Test
    void Should_ReturnTagMap_When_GroupBooksByTag() {
        Map<String, List<Book>> expected = BookFixture.mapByTag();
        Map<String, List<Book>> actual = library.groupBooksByTags();
        assertEquals(expected, actual);
    }
}
