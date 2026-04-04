package model;

/**
 * Represents a Bill generated for a Patient.
 * Demonstrates: Encapsulation, Validation
 */
public class Billing {
    private int     billId;
    private Patient patient;
    private double  amount;

    public Billing(int id, Patient patient, double amount) {
        if (patient == null) {
            throw new IllegalArgumentException("Billing requires a valid patient.");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("Bill amount cannot be negative.");
        }
        this.billId  = id;
        this.patient = patient;
        this.amount  = amount;
    }

    // Getters
    public int    getBillId()  { return billId; }
    public double getAmount()  { return amount; }
    public Patient getPatient(){ return patient; }

    /** Prints a formatted bill to the console */
    public void generateBill() {
        System.out.println("============== BILL ==============");
        System.out.println("Bill ID  : " + billId);
        System.out.println("Patient  : " + patient.getName());
        System.out.println("Disease  : " + patient.getDisease());
        System.out.printf ("Amount   : Rs. %.2f%n", amount);
        System.out.println("Status   : " + (patient.isAdmitted() ? "Pending" : "Settled"));
        System.out.println("==================================");
    }
}
