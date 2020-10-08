package entities;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Book {

    private String title;
    private String author;
    private int price;
    private List<String> tags;

    public Book(String title, String author, int price, List<String> tags) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return price == book.price &&
                title.equals(book.title) &&
                author.equals(book.author) &&
                tags.equals(book.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, price, tags);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", tags=" + tags +
                '}';
    }
}
