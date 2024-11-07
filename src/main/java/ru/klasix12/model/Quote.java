package ru.klasix12.model;

import java.util.List;

public class Quote {
    private String quote;
    private Author author;
    private List<String> tags;

    public Quote() {
    }

    public Quote(String quote, Author author, List<String> tags) {
        this.quote = quote;
        this.author = author;
        this.tags = tags;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "quote='" + quote + '\'' +
                ", author=" + author +
                ", tags=" + tags +
                '}';
    }
}
