package entities;

import java.util.*;

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
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().contains(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<String> getDistinctTags() {
        List<String> result = new ArrayList<>();
        for (Book book : books) {
            for (String tag : book.getTags()) {
                if (!result.contains(tag)) {
                    result.add(tag);
                }
            }
        }
        return result;
    }

    public Optional<Book> getAnyBookByTag(String tag) {
        Book result = null;
        for (Book book : books) {
            for (String bookTag : book.getTags()) {
                if (bookTag.equals(tag)) {
                    result = book;
                    break;
                }
            }
        }
        return Optional.ofNullable(result);
    }

    public List<Book> getTopRatedBooks() {
        List<Book> result = new ArrayList<>();
        double highest = 0;
        int highestIndex = -1;
        double secondHighest = 0;
        int secondHighestIndex = -1;
        for (int i = 0; i < books.size(); i++) {
            double value = books.get(i).getRating();
            if (value > highest) {
                double tmp = highest;
                int tmpIndex = highestIndex;
                highest = value;
                highestIndex = i;
                secondHighest = tmp;
                secondHighestIndex = tmpIndex;
            } else if (value > secondHighest) {
                secondHighest = value;
                secondHighestIndex = i;
            }
        }
        result.add(books.get(highestIndex));
        result.add(books.get(secondHighestIndex));
        return result;
    }

    public Book getMostExpensiveBook() {
        Book result = books.get(0);
        for (Book book : books) {
            if (result.getPrice() < book.getPrice()) {
                result = book;
            }
        }
        return result;
    }

    public int getTotalPriceByTag(String tag) {
        int result = 0;
        for (Book book : books) {
            if (book.getTags().contains(tag)) {
                result += book.getPrice();
            }
        }
        return result;
    }

    public boolean hasBooksInLibrary(String author) {
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                found = true;
                break;
            }
        }
        return found;
    }

    public boolean areAllBooksInTagWrittenByAuthor(String tag, String author) {
        List<Book> booksWithTag = new ArrayList<>();
        for (Book book : books) {
            if (book.getTags().contains(tag)) {
                booksWithTag.add(book);
            }
        }
        for (Book book : booksWithTag) {
            if (!author.equals(book.getAuthor())) {
                return false;
            }
        }
        return true;
    }

    public Map<String, List<Book>> groupBooksByAuthor() {
        Map<String, List<Book>> result = new HashMap<>();
        for (Book book : books) {
            if (result.containsKey(book.getAuthor())) {
                result.get(book.getAuthor()).add(book);
            } else {
                ArrayList<Book> books = new ArrayList<>();
                books.add(book);
                result.put(book.getAuthor(), books);
            }
        }
        return result;
    }

    public Map<String, List<Book>> groupBooksByTags() {
        Map<String, List<Book>> result = new HashMap<>();
        for (Book book : books) {
            for (String tag : book.getTags()) {
                if (result.containsKey(tag)) {
                    result.get(tag).add(book);
                } else {
                    ArrayList<Book> books = new ArrayList<>();
                    books.add(book);
                    result.put(tag, books);
                }
            }
        }
        return result;
    }
}
