package model;

/**
 * Represents an Appointment between a Patient and a Doctor.
 * Demonstrates: Composition (has-a relationship)
 */
public class Appointment {
    private int     appointmentId;
    private Patient patient;
    private Doctor  doctor;
    private String  date;

    public Appointment(int id, Patient patient, Doctor doctor, String date) {
        if (patient == null || doctor == null || date == null || date.isBlank()) {
            throw new IllegalArgumentException("Appointment requires valid patient, doctor, and date.");
        }
        this.appointmentId = id;
        this.patient       = patient;
        this.doctor        = doctor;
        this.date          = date;
    }

    // Getters
    public int     getAppointmentId() { return appointmentId; }
    public Patient getPatient()       { return patient; }
    public Doctor  getDoctor()        { return doctor; }
    public String  getDate()          { return date; }

    public void display() {
        System.out.println("Appointment ID : " + appointmentId);
        System.out.println("Patient        : " + patient.getName());
        System.out.println("Doctor         : " + doctor.getName() + " (" + doctor.getSpecialization() + ")");
        System.out.println("Date           : " + date);
    }
}
