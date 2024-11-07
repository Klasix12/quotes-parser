package ru.klasix12.model;

import java.time.LocalDate;

public class Author {
    private String name;
    private LocalDate birthday;
    private String bornLocation;

    public Author() {
    }

    public Author(String name, LocalDate birthday, String cityOfBirth, String countryOfBirth, String description) {
        this.name = name;
        this.birthday = birthday;
        this.bornLocation = cityOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getBornLocation() {
        return bornLocation;
    }

    public void setBornLocation(String bornLocation) {
        this.bornLocation = bornLocation;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", bornLocation='" + bornLocation + '\'' +
                '}';
    }
}
