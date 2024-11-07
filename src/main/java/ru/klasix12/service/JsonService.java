package ru.klasix12.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.klasix12.adapter.LocalDateAdapter;
import ru.klasix12.model.Quote;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class JsonService {
    private final Gson gson;

    public JsonService() {
        this.gson = new GsonBuilder().setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();
    }

    public void saveQuotesToFile(File file, List<Quote> quotes) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            String json = gson.toJson(quotes);
            bw.write(json);
        } catch (IOException e) {
            System.out.println("Не удалось записать в файл:\n" + e.getMessage());
        }
    }
}