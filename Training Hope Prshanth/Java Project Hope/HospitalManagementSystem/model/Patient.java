package model;

/**
 * Represents a Patient in the hospital.
 * Demonstrates: Inheritance (extends Person), Encapsulation, Polymorphism (display override)
 */
public class Patient extends Person {
    private int patientId;
    private String disease;
    private boolean admitted;

    public Patient(int id, String name, int age, String gender, String disease) {
        super(name, age, gender);
        this.patientId = id;
        this.disease   = disease;
        this.admitted  = true;
    }

    // Getters
    public int    getId()        { return patientId; }
    public String getDisease()   { return disease; }
    public boolean isAdmitted()  { return admitted; }

    /** Discharge this patient from the hospital */
    public void discharge() {
        this.admitted = false;
        System.out.println("[INFO] Patient '" + name + "' has been discharged successfully.");
    }

    @Override
    public void display() {
        System.out.println("Patient ID   : " + patientId);
        System.out.println("Name         : " + name);
        System.out.println("Age / Gender : " + age + " / " + gender);
        System.out.println("Disease      : " + disease);
        System.out.println("Status       : " + (admitted ? "Admitted" : "Discharged"));
    }
}
