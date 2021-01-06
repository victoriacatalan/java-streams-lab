import entities.Book;

import java.util.List;
import java.util.Map;

public final class BookFixture {

    public static List<Book> generateLibrary() {
        return List.of(
                getGolden(),
                getOCP(),
                getInk(),
                getLotr(),
                getSilmarillon()
        );
    }

    public static Map<String, List<Book>> mapByAuthor() {
        return Map.of("Alphonso Dunn", List.of(getInk()),
                "Philip Pullman", List.of(getGolden()),
                "J. R. R. Tolkien", List.of(getLotr(), getSilmarillon()),
                "Jeanne Boyarsky", List.of(getOCP()));
    }

    public static Map<String, List<Book>> mapByTag() {
        return Map.of("YA", List.of(getGolden()),
                "Fantasy", List.of(getGolden(), getLotr(), getSilmarillon()),
                "Java", List.of(getOCP()),
                "Study Guide", List.of(getOCP(), getInk()),
                "Drawing", List.of(getInk()));
    }

    public static Book getGolden() {
        return new Book("The golden compass", "Philip Pullman", 79, List.of("YA", "Fantasy"), 3.7);
    }

    public static Book getOCP() {
        return new Book("OCP", "Jeanne Boyarsky", 432, List.of("Java", "Study Guide"), 3.2);
    }

    public static Book getInk() {
        return new Book("Pen and Ink drawing", "Alphonso Dunn", 235, List.of("Drawing", "Study Guide"), 4.3);
    }

    public static Book getLotr() {
        return new Book("Lord of the Rings", "J. R. R. Tolkien", 123, List.of("Fantasy"), 4.9);
    }

    public static Book getSilmarillon() {
        return new Book("Silmarillon", "J. R. R. Tolkien", 125, List.of("Fantasy"), 2.9);
    }

}
