package main;

import model.Patient;
import model.Doctor;
import model.Appointment;
import model.Billing;
import service.HospitalService;
import util.IdGenerator;

import java.util.List;

/**
 * Entry point for the Hospital Management System.
 * Demonstrates all core features: OOP, Exception Handling, Search, Discharge, Billing.
 */
import model.Patient;
import model.Doctor;
import model.Appointment;
import model.Billing;
import service.HospitalService;
import util.IdGenerator;

import java.util.Scanner;
import java.util.List;

/**
 * Entry point for the Hospital Management System.
 * Interactive CLI version with Scanner for user input.
 */
public class Main {

    public static void main(String[] args) {
        HospitalService service = new HospitalService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║     HOSPITAL MANAGEMENT SYSTEM v1.0     ║");
        System.out.println("╚══════════════════════════════════════════╝");

        while (true) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Register Doctor");
            System.out.println("2. Admit Patient");
            System.out.println("3. Book Appointment");
            System.out.println("4. Generate Bill");
            System.out.println("5. View All Patients");
            System.out.println("6. View All Doctors");
            System.out.println("7. View All Appointments");
            System.out.println("8. Search Patient by Name");
            System.out.println("9. Discharge Patient");
            System.out.println("10. Hospital Summary");
            System.out.println("0. Exit");
            System.out.print("Select Operation: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1: // Register Doctor
                    System.out.print("Enter Doctor Name: ");
                    String dName = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int dAge = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Gender: ");
                    String dGender = scanner.nextLine();
                    System.out.print("Enter Specialization: ");
                    String dSpec = scanner.nextLine();
                    service.addDoctor(new Doctor(IdGenerator.getDoctorId(), dName, dAge, dGender, dSpec));
                    break;

                case 2: // Admit Patient
                    System.out.print("Enter Patient Name: ");
                    String pName = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int pAge = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Gender: ");
                    String pGender = scanner.nextLine();
                    System.out.print("Enter Disease: ");
                    String pDisease = scanner.nextLine();
                    service.addPatient(new Patient(IdGenerator.getPatientId(), pName, pAge, pGender, pDisease));
                    break;

                case 3: // Book Appointment
                    try {
                        System.out.print("Enter Patient ID: ");
                        int patientId = Integer.parseInt(scanner.nextLine());
                        Patient p = service.findPatient(patientId);
                        System.out.print("Enter Doctor ID: ");
                        int doctorId = Integer.parseInt(scanner.nextLine());
                        Doctor d = service.findDoctor(doctorId);
                        System.out.print("Enter Date (e.g., 05-Apr-2026): ");
                        String date = scanner.nextLine();
                        service.bookAppointment(new Appointment(IdGenerator.getAppointmentId(), p, d, date));
                    } catch (Exception e) {
                        System.out.println("[ERROR] " + e.getMessage());
                    }
                    break;

                case 4: // Generate Bill
                    try {
                        System.out.print("Enter Patient ID: ");
                        int pId = Integer.parseInt(scanner.nextLine());
                        Patient p = service.findPatient(pId);
                        System.out.print("Enter Bill Amount: ");
                        double amount = Double.parseDouble(scanner.nextLine());
                        Billing b = new Billing(IdGenerator.getBillId(), p, amount);
                        service.addBill(b);
                        b.generateBill();
                    } catch (Exception e) {
                        System.out.println("[ERROR] " + e.getMessage());
                    }
                    break;

                case 5: service.showAllPatients(); break;
                case 6: service.showAllDoctors(); break;
                case 7: service.showAllAppointments(); break;

                case 8: // Search Patient
                    System.out.print("Enter Name Search Term: ");
                    String searchTerm = scanner.nextLine();
                    List<Patient> found = service.searchPatientByName(searchTerm);
                    if (found.isEmpty()) {
                        System.out.println("No matching patients found.");
                    } else {
                        found.forEach(Patient::display);
                    }
                    break;

                case 9: // Discharge
                    try {
                        System.out.print("Enter Patient ID to Discharge: ");
                        int pIdToDischarge = Integer.parseInt(scanner.nextLine());
                        service.findPatient(pIdToDischarge).discharge();
                    } catch (Exception e) {
                        System.out.println("[ERROR] " + e.getMessage());
                    }
                    break;

                case 10: service.showSummary(); break;

                case 0:
                    System.out.println("Exiting System. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("[WARNING] Invalid choice. Try again.");
            }
        }
    }
}
