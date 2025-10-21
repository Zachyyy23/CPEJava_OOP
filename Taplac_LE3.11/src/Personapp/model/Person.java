package Personapp.model;

import Personapp.program.PersonTester;

public class Person {
    private String name;
    private int age;

    public Person() {
        setName("");
        setAge(0);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setPerson (String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean equals(Person other) {
        return this.name.equals(other.name) && this.age == other.age;
    }

    public boolean sameName (Person other) {
        return this.name.equals(other.name);
    }

    public boolean sameAge(Person other) {
        return this.age == other.age;
    }

    public boolean youngerThan(Person other) {
        return this.age < other.age;
    }

    public boolean olderThan(Person other) {
        return this.age > other.age;
    }
}
