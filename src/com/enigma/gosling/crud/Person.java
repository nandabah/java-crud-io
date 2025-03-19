package com.enigma.gosling.crud;

import java.lang.reflect.Parameter;

public class Person {
    private Integer id;
    private String name;
    private Integer age;

    public Person(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + age;
    }

    public static Person fromString(String personPerLine){
        String[] trim = personPerLine.split(",");
        // return person hasil trim
        return new Person(Integer.parseInt(trim[0]), trim[1], Integer.parseInt(trim[2]));
    }
}
