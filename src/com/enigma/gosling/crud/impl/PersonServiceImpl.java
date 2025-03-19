package com.enigma.gosling.crud.impl;

import com.enigma.gosling.crud.Person;
import com.enigma.gosling.crud.PersonService;
import com.enigma.gosling.crud.constant.Constant;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonServiceImpl implements PersonService {

    private static final File file = new File("persons.txt");

    @Override
    public void create(Person person) {
        try (FileWriter fileWriter = new FileWriter(file, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            // 1,adib,19 -> csv (comma separated value)
            bufferedWriter.write(person.toString()); // id,name,age
            bufferedWriter.newLine(); // line baru

            // message success (ambil dari constant)
            System.out.println(Constant.SUCCESS_CREATE);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public List<Person> viewAll() {
        List<Person> personList = new ArrayList<>(); // Siapkan list kosong
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while (true) {
                // Buffer
                String person = bufferedReader.readLine();
                if (person == null) break;
                // Kirim person per line
                personList.add(Person.fromString(person));
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        return personList;
    }

    @Override
    public void updateById(int id, String newName, int newAge) {
        List<Person> personList = viewAll();

        for (Person person : personList) {
            if (person.getId() == id) {
                // Method set dari List -> set(index, element baru)
                personList.set(personList.indexOf(person), new Person(id, newName, newAge));
                break;
            }
        }

        // Tulis lagi ke file
        saveAll(personList);
    }

    private void saveAll(List<Person> personList){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (Person person : personList) {
                bufferedWriter.write(person.toString());
                bufferedWriter.newLine();
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void deleteById(int id) {
        // Baca
        List<Person> personList = viewAll();
        /*for (Person person : personList) {
            if (person.getId() == id) {
                personList.remove(person);
            }
        }
        */
        personList.removeIf(person -> person.getId() == id);
        saveAll(personList);
    }
}
