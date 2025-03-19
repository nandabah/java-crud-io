package com.enigma.gosling.crud;

import com.enigma.gosling.crud.impl.PersonServiceImpl;

import java.util.List;
import java.util.Scanner;

public class CrudMainApp {
    private static final PersonService personService = new PersonServiceImpl();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Case 1:
        //create();
        // Case 2:
        //read();
        // Case 3:
        // update();
        // Case 4:
        delete();
        read();
    }

    public static void create() {
        Integer id = Integer.parseInt(scanner.nextLine());
        String name = scanner.nextLine();
        Integer age = Integer.parseInt(scanner.nextLine());

        Person newPerson = new Person(id, name, age);
        personService.create(newPerson); // Scanner
    }

    public static void read() {
        List<Person> persons = personService.viewAll();

        for (Person person : persons) {
            System.out.println("ID: " + person.getId());
            System.out.println("Name: " + person.getName());
            System.out.println("Age: " + person.getAge());
        }
    }

    public static void update() {
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter New Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new Age: ");
        int age = Integer.parseInt(scanner.nextLine());

        personService.updateById(id, name, age);
    }

    public static void delete(){
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        personService.deleteById(id);
    }
}
