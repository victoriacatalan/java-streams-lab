package entities;

import java.util.*;
import java.util.stream.Collectors;

public class Library {
    private final List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    public List<Book> getAllBooksByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().contains(author))
                .collect(Collectors.toList());
    }

    public Book getMostExpensiveBook() {
        return books.stream()
                .max(Comparator.comparing(Book::getPrice))
                .orElse(null);
    }

    public int getTotalPriceByTag(String tag) {
        return books.stream()
                .filter(book -> book.getTags().contains(tag))
                .mapToInt(Book::getPrice)
                .sum();
    }

    public Optional<Book> getAnyBookByTag(String tag) {
        return books.stream()
                .filter(book -> book.getTags().contains(tag))
                .findFirst();
    }

    public boolean hasBooksInLibrary(String author) {
        return books.stream().anyMatch(book -> book.getAuthor().equals(author));
    }

    public boolean areAllBooksInTagWrittenByAuthor(String tag, String author) {
        return books.stream()
                .filter(book -> book.getTags().contains(tag))
                .allMatch(book -> author.equals(book.getAuthor()));
    }

    public List<String> getAllUniqueTags() {
        return books.stream()
                .flatMap(book -> book.getTags().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    public Map<String, List<Book>> groupBooksByAuthor() {
        return books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor));
    }

    public List<Book> getTopRatedBooks() {
        return books.stream()
                .sorted(Comparator.comparing(Book::getRating).reversed())
                .limit(2)
                .collect(Collectors.toList());
    }

    public Map<String, List<Book>> groupBooksByTags() {
        return books.stream()
                .flatMap(book -> book.getTags().stream().map(tag -> Map.entry(tag, book)))
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.mapping(Map.Entry::getValue, Collectors.toList())));
    }
}
