package ru.klasix12;

import ru.klasix12.model.Quote;
import ru.klasix12.parse.Parser;
import ru.klasix12.service.JsonService;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        List<Quote> quotes = Parser.parseQuotes("https://quotes.toscrape.com/");

        for (int i = 1; i <= 10; i++) {
            quotes.addAll(Parser.parseQuotes("https://quotes.toscrape.com/page/" + i + "/"));
        }

        JsonService jsonService = new JsonService();

        jsonService.saveQuotesToFile(new File("./quotes.json"), quotes);

        long endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1_000_000);
    }
}
