package model;

/**
 * Abstract base class representing a Person in the hospital system.
 * Demonstrates: Abstraction, Encapsulation
 */
public abstract class Person {
    protected String name;
    protected int age;
    protected String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // Getters
    public String getName() { return name; }
    public int getAge()     { return age; }
    public String getGender() { return gender; }

    // Abstract method — forces subclasses to implement their own display
    public abstract void display();
}
