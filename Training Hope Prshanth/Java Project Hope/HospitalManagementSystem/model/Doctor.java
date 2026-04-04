package model;

/**
 * Represents a Doctor in the hospital.
 * Demonstrates: Inheritance (extends Person), Encapsulation, Polymorphism (display override)
 */
public class Doctor extends Person {
    private int    doctorId;
    private String specialization;

    public Doctor(int id, String name, int age, String gender, String specialization) {
        super(name, age, gender);
        this.doctorId       = id;
        this.specialization = specialization;
    }

    // Getters
    public int    getId()             { return doctorId; }
    public String getSpecialization() { return specialization; }

    @Override
    public void display() {
        System.out.println("Doctor ID      : " + doctorId);
        System.out.println("Name           : " + name);
        System.out.println("Age / Gender   : " + age + " / " + gender);
        System.out.println("Specialization : " + specialization);
    }
}
