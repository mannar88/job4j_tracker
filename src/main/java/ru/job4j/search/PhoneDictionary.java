package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        BiPredicate<Person, String> predicateName = (p, s) -> p.getName().contains(s);
        BiPredicate<Person, String> predicateSurnane = (p, s) -> p.getSurname().contains(s);
        BiPredicate<Person, String> predicateFone = (p, s) -> p.getPhone().contains(s);
        BiPredicate<Person, String> predicateAdress = (p, s) -> p.getAddress().contains(s);
        BiPredicate<Person, String> combine = (p, s) -> predicateName.test(p, s) || predicateSurnane.test(p, s)
    || predicateFone.test(p, s) || predicateAdress.test(p, s);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person, key)) {
                result.add(person);
            }
        }
        return result;
    }}