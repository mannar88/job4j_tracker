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
ArrayList <Person> result = new ArrayList<>();
        Predicate < Person> predicateName = p -> p.getName().contains(key);
Predicate < Person> predicateSurname = p -> p.getSurname().contains(key);
Predicate <Person> predicateFone = p -> p.getPhone().contains(key);
Predicate <Person> predicateAdress = p -> p.getAddress().contains(key);
Predicate <Person> combine = predicateName.or(predicateSurname.or(predicateFone.or(predicateAdress)));
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }}