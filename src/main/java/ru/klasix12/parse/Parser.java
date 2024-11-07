package ru.klasix12.parse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.klasix12.mapper.AuthorMapper;
import ru.klasix12.mapper.QuoteMapper;
import ru.klasix12.model.Author;
import ru.klasix12.model.Quote;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    private final static String QUOTES_URL = "https://quotes.toscrape.com";

    private Parser() {
    }

    public static List<Quote> parseQuotes(String url) {
        List<Quote> parsedQuotes = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(url).get();
            Elements quotes = doc.select(".quote");
            for (Element quote : quotes) {
                Quote newQuote = QuoteMapper.quoteFromElement(quote);
                Author author = parseAuthor(QUOTES_URL + quote.getElementsByTag("a").getFirst().attr("href"));
                newQuote.setAuthor(author);
                parsedQuotes.add(newQuote);
            }
        } catch (IOException e) {
            System.out.println("Не удалось подключиться:\n" + e.getMessage());
        }
        return parsedQuotes;
    }

    public static Author parseAuthor(String url) {
        Author author = null;
        try {
            Document doc = Jsoup.connect(url).get();
            author = AuthorMapper.authorFromElement(doc.getElementsByClass("author-details").getFirst());
        } catch (IOException e) {
            System.out.println("Не удалось подключиться:\n" + e.getMessage());
        }
        return author;
    }
}
