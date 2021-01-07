package entities;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Block 1
 * {@link Library#getAllBooksByAuthor(String)}
 * {@link Library#getDistinctTags()}
 * {@link Library#getAnyBookByTag(String)}
 * {@link Library#getTopRatedBooks()}
 *
 * Block 2
 * {@link Library#getMostExpensiveBook()}
 * {@link Library#getTotalPriceByTag(String)}
 * {@link Library#hasBooksInLibrary(String)}
 * {@link Library#areAllBooksInTagWrittenByAuthor(String, String)}
 *
 * Block 3
 * {@link Library#groupBooksByAuthor()}
 * {@link Library#groupBooksByTags()}
 */
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

    public List<String> getDistinctTags() {
        return books.stream()
                .flatMap(book -> book.getTags().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    public Optional<Book> getAnyBookByTag(String tag) {
        return books.stream()
                .filter(book -> book.getTags().contains(tag))
                .findAny();
    }

    public List<Book> getTopRatedBooks() {
        return books.stream()
                .sorted(Comparator.comparing(Book::getRating).reversed())
                .limit(2)
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

    public boolean hasBooksInLibrary(String author) {
        return books.stream().anyMatch(book -> book.getAuthor().equals(author));
    }

    public boolean areAllBooksInTagWrittenByAuthor(String tag, String author) {
        return books.stream()
                .filter(book -> book.getTags().contains(tag))
                .allMatch(book -> author.equals(book.getAuthor()));
    }

    public Map<String, List<Book>> groupBooksByAuthor() {
        return books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor));
    }

    public Map<String, List<Book>> groupBooksByTags() {
        Map<String, List<Book>> map = new HashMap<>();
        for (Book book : books) {
            for (String tag : book.getTags()) {
                map.computeIfAbsent(tag, k -> new ArrayList<>()).add(book);
            }
        }
        return map;

        /*  An alternative stream solution
        return books.stream()
                .flatMap(book -> book.getTags().stream().map(tag -> Map.entry(tag, book)))
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.mapping(Map.Entry::getValue, Collectors.toList())));
        */
    }
}
