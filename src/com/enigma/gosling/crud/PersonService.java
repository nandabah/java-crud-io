package com.enigma.gosling.crud;

import java.util.List;

public interface PersonService {
    void create(Person person);
    List<Person> viewAll(); // View All Persons
    void updateById(int id, String newName, int newAge);
    void deleteById(int id);
}
