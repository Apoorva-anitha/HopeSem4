package util;

/**
 * Utility class to generate unique IDs for Hospital entities.
 * Uses static counters to ensure uniqueness across the session.
 * Demonstrates: Static methods, Utility class pattern
 */
public class IdGenerator {
    private static int patientId     = 100;
    private static int doctorId      = 200;
    private static int appointmentId = 300;
    private static int billId        = 400;

    // Private constructor — this class should never be instantiated
    private IdGenerator() {}

    public static int getPatientId()     { return patientId++; }
    public static int getDoctorId()      { return doctorId++; }
    public static int getAppointmentId() { return appointmentId++; }
    public static int getBillId()        { return billId++; }
}
