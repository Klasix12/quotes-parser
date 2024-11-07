package ru.klasix12.mapper;

import org.jsoup.nodes.Element;
import ru.klasix12.model.Author;

import java.time.LocalDate;
import java.time.Month;

public class AuthorMapper {
    public static Author authorFromElement(Element element) {
        Author author = new Author();
        author.setName(element.getElementsByClass("author-title").getFirst().text());

        String bornDate = element.getElementsByClass("author-born-date").getFirst().text();
        Month bornMonth = Month.valueOf(bornDate.substring(0, bornDate.indexOf(" ")).toUpperCase());
        int bornDay = Integer.parseInt(bornDate.substring(bornDate.indexOf(" ") + 1, bornDate.indexOf(", ")));
        int bornYear = Integer.parseInt(bornDate.substring(bornDate.indexOf(", ") + 2));
        LocalDate bornLocalDate = LocalDate.of(bornYear, bornMonth, bornDay);
        author.setBirthday(bornLocalDate);

        String bornLocation = element.getElementsByClass("author-born-location").getFirst().text();
        author.setBornLocation(bornLocation.substring(bornLocation.indexOf("in ") + 3));
        return author;
    }
}
