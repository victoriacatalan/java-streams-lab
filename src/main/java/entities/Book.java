package entities;

import java.util.List;
import java.util.Objects;

public class Book {

    private String title;
    private String author;
    private int price;
    private List<String> tags;
    private double rating;

    public Book(String title, String author, int price, List<String> tags, double rating) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.tags = tags;
        this.rating = rating;
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return price == book.price &&
                Double.compare(book.rating, rating) == 0 &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(tags, book.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, price, tags, rating);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", tags=" + tags +
                ", rating=" + rating +
                '}';
    }
}
