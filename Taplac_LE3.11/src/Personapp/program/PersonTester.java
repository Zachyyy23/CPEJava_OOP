package Personapp.program;/*
Test whether two Personapp.model.Person objects are equal (have the same name and age).
        ▪ Test whether two Personapp.model.Person objects have the same name.
▪ Test whether two Personapp.model.Person objects are the same age.
▪ Test whether one Personapp.model.Person object is older than another.
▪ Test whether one Personapp.model.Person object is younger than another.
*/

import Personapp.model.Person;
import Personapp.model.UserInput;

public class PersonTester {
    static void main(String[] args) {
        UserInput input = new UserInput();

        String name1 = input.getString("Enter name for Person 1:  ");
        int age1 = input.getInt("Enter age for Person 1: ");
        Person person1 = new Person (name1,age1);

        String name2 = input.getString("Enter name for Person 2:  ");
        int age2 = input.getInt("Enter age for Person 2: ");
        Person person2 = new Person (name2,age2);

        String name3 = input.getString("Enter name for Person 3:  ");
        int age3 = input.getInt("Enter age for Person 3: ");
        Person person3 = new Person (name3,age3);

        if(person1.equals(person2)) {
            System.out.println("Test Result Person 1 and Person 2 = Equal");
        }else {
            System.out.println("Test Result Person 1 and Person 2 = Not Equal");
        }

        if(person2.sameName(person3)) {
            System.out.println("Test Result Person 2 and Person 3 = Have the Same Name");
        }else {
            System.out.println("Test Result Person 2 and Person 3 = Does not Have the Same Name");
        }

        if(person1.sameAge(person2)) {
            System.out.println("Test Result Person 1 and Person 2 = Have the Same Age");
        } else {
            System.out.println("Test Result Person 1 and Person 2 = Does not Have the Same Age");
        }

        if(person1.youngerThan(person3)) {
            System.out.println("Test Result Person 1 and Person 3 = Person 1 is Younger than Person 2");
        }else {
            System.out.println("Test Result Person 1 and Person 3 = Person 1 is Not Younger than Person 3");
        }

        if(person2.olderThan(person3)) {
            System.out.println("Test Result Person 2 and Person 3 = Person 2 is Older than Person 3");
        } else {
            System.out.println("Test Result Person 2 and Person 3 = Person 2 is Not Older than Person 3");
        }


    }

}
