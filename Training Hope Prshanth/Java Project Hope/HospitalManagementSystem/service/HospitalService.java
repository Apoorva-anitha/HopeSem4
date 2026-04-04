package service;

import model.Patient;
import model.Doctor;
import model.Appointment;
import model.Billing;

import java.util.ArrayList;
import java.util.List;

/**
 * Core service layer — manages all hospital operations.
 * Demonstrates: Encapsulation, Exception Handling, Searching, Validation
 */
public class HospitalService {

    private List<Patient>     patients     = new ArrayList<>();
    private List<Doctor>      doctors      = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();
    private List<Billing>     bills        = new ArrayList<>();

    // ─── Patient Operations ────────────────────────────────────────────────

    public void addPatient(Patient p) {
        if (p == null) throw new IllegalArgumentException("Patient cannot be null.");
        patients.add(p);
        System.out.println("[INFO] Patient '" + p.getName() + "' admitted successfully (ID: " + p.getId() + ").");
    }

    /**
     * Finds a patient by ID.
     * @throws RuntimeException if patient is not found
     */
    public Patient findPatient(int id) {
        for (Patient p : patients) {
            if (p.getId() == id) return p;
        }
        throw new RuntimeException("Patient with ID " + id + " not found.");
    }

    /** Search patients by name (case-insensitive, partial match) */
    public List<Patient> searchPatientByName(String name) {
        List<Patient> result = new ArrayList<>();
        for (Patient p : patients) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
    }

    public void showAllPatients() {
        if (patients.isEmpty()) {
            System.out.println("[INFO] No patients currently registered.");
            return;
        }
        System.out.println("\n========== ALL PATIENTS ==========");
        for (Patient p : patients) {
            p.display();
            System.out.println("----------------------------------");
        }
    }

    // ─── Doctor Operations ─────────────────────────────────────────────────

    public void addDoctor(Doctor d) {
        if (d == null) throw new IllegalArgumentException("Doctor cannot be null.");
        doctors.add(d);
        System.out.println("[INFO] Doctor '" + d.getName() + "' added (ID: " + d.getId() + ").");
    }

    public Doctor findDoctor(int id) {
        for (Doctor d : doctors) {
            if (d.getId() == id) return d;
        }
        throw new RuntimeException("Doctor with ID " + id + " not found.");
    }

    public void showAllDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("[INFO] No doctors currently registered.");
            return;
        }
        System.out.println("\n========== ALL DOCTORS ===========");
        for (Doctor d : doctors) {
            d.display();
            System.out.println("----------------------------------");
        }
    }

    // ─── Appointment Operations ────────────────────────────────────────────

    public void bookAppointment(Appointment a) {
        if (a == null) throw new IllegalArgumentException("Appointment cannot be null.");
        appointments.add(a);
        System.out.println("[INFO] Appointment booked (ID: " + a.getAppointmentId() + ").");
    }

    public void showAllAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("[INFO] No appointments scheduled.");
            return;
        }
        System.out.println("\n======= ALL APPOINTMENTS =========");
        for (Appointment a : appointments) {
            a.display();
            System.out.println("----------------------------------");
        }
    }

    // ─── Billing Operations ────────────────────────────────────────────────

    public void addBill(Billing b) {
        if (b == null) throw new IllegalArgumentException("Billing record cannot be null.");
        bills.add(b);
    }

    public void showAllBills() {
        if (bills.isEmpty()) {
            System.out.println("[INFO] No bills generated yet.");
            return;
        }
        for (Billing b : bills) {
            b.generateBill();
        }
    }

    // ─── Summary ───────────────────────────────────────────────────────────

    public void showSummary() {
        System.out.println("\n========== HOSPITAL SUMMARY ==========");
        System.out.println("Total Patients     : " + patients.size());
        System.out.println("Total Doctors      : " + doctors.size());
        System.out.println("Total Appointments : " + appointments.size());
        System.out.println("Total Bills        : " + bills.size());
        long admitted = patients.stream().filter(Patient::isAdmitted).count();
        System.out.println("Currently Admitted : " + admitted);
        System.out.println("======================================");
    }
}
