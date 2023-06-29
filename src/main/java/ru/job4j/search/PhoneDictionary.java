package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список пользователей, которые прошли проверку.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> predicateName = p -> p.getName().contains(key);
        Predicate<Person> predicateSurname = p -> p.getSurname().contains(key);
        Predicate<Person> predicatePhone = p -> p.getPhone().contains(key);
        Predicate<Person> predicateAddress = p -> p.getAddress().contains(key);
        Predicate<Person> combine = predicateName.or(predicateSurname).or(predicateSurname).or(predicatePhone).or(predicateAddress);
        var result = new ArrayList<Person>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
