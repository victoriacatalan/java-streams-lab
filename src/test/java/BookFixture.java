import entities.Book;

import com.sun.tools.javac.util.List;

public final class BookFixture {

    public static List<Book> generateLibrary() {
        return List.of(
                getGolden(),
                getOCP(),
                getInk(),
                getLotr()
                );
    }

    public static Book getGolden() {
        return new Book("The golden compass", "Philip Pullman", 79, List.of("YA", "Fantasy"));
    }

    public static Book getOCP() {
        return new Book("OCP", "Jeanne Boyarsky", 432, List.of("Java", "Study Guide"));
    }

    public static Book getInk() {
        return new Book("Pen and Ink drawing", "Alphonso Dunn", 235, List.of("Drawing", "Study Guide"));
    }

    public static Book getLotr() {
        return new Book("Lord of the Rings", "J. R. R Tolkien", 123, List.of("Fantasy"));
    }

    public static Book getSilmarillon() {
        return new Book("Lord of the Rings", "J. R. R Tolkien", 123, List.of("Fantasy"));
    }

}
