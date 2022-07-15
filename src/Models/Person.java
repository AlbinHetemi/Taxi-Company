package Models;

import Enums.PersonStatus;

public class Person {
    private String name;
    private String surname;
    private String location;
    private int years;
    private int birthYear;
    private int ID;

    public Person(String name, String surname, String location, int years, int birthYear, int ID) {
        this.name = name;
        this.surname = surname;
        this.location = location;
        this.years = years;
        this.birthYear = birthYear;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void printoPersonin() {
        System.out.printf("Emri: %s, Mbiemri: %s, Lokacioni: %s , Vitet: %s , Data e Lindjes: %s, Id e Personit: " +
                "%d %n", getName(), getSurname(), getLocation(), getYears(), getBirthYear(), getID());
    }
}
