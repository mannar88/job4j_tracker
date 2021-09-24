package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person value  : persons) {
            if (value.getName().equals(key) || value.getPhone().equals(key) || value.getAddress().equals(key) || value.getSurname().equals(key)) {
result.add(value);
            }
        }
        return result;
    }
}