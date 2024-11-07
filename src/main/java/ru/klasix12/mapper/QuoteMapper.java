package ru.klasix12.mapper;

import org.jsoup.nodes.Element;
import ru.klasix12.model.Quote;

import java.util.stream.Collectors;

public class QuoteMapper {
    private QuoteMapper() {
    }

    public static Quote quoteFromElement(Element element) {
        Quote quote = new Quote();
        quote.setQuote(element.getElementsByClass("text").getFirst().text().replaceAll("[”“]", ""));
        quote.setTags(element.getElementsByClass("tag")
                .stream()
                .map(Element::text)
                .collect(Collectors.toList()));
        return quote;
    }
}
