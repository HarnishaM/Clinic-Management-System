import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;


public class ClinicManagementSystem {
    private HashMap<Integer, Patient> patients = new HashMap<>();
    private HashMap<Integer, Doctor> doctors = new HashMap<>();
    private ArrayList<Appointment> appointments = new ArrayList<>();
    private int appointmentCounter = 1;

    // Add a new patient
    public void addPatient(Patient patient) {
        if (patients.containsKey(patient.getId())) {
            System.out.println("Patient with this ID already exists.");
        } else {
            patients.put(patient.getId(), patient);
            System.out.println("Patient added successfully.");
        }
    }

    // Remove a patient
    public void removePatient(int patientId) {
        if (patients.remove(patientId) != null) {
            System.out.println("Patient removed successfully.");
        } else {
            System.out.println("Patient not found.");
        }
    }

    // Update patient details
    public void updatePatient(int patientId, Patient updatedPatient) {
        if (patients.containsKey(patientId)) {
            patients.put(patientId, updatedPatient);
            System.out.println("Patient updated successfully.");
        } else {
            System.out.println("Patient not found.");
        }
    }

    // Add a new doctor
    public void addDoctor(Doctor doctor) {
        if (doctors.containsKey(doctor.getId())) {
            System.out.println("Doctor with this ID already exists.");
        } else {
            doctors.put(doctor.getId(), doctor);
            System.out.println("Doctor added successfully.");
        }
    }

    // Remove a doctor
    public void removeDoctor(int doctorId) {
        if (doctors.remove(doctorId) != null) {
            System.out.println("Doctor removed successfully.");
        } else {
            System.out.println("Doctor not found.");
        }
    }

    // Update doctor details
    public void updateDoctor(int doctorId, Doctor updatedDoctor) {
        if (doctors.containsKey(doctorId)) {
            doctors.put(doctorId, updatedDoctor);
            System.out.println("Doctor updated successfully.");
        } else {
            System.out.println("Doctor not found.");
        }
    }

    // Schedule an appointment
    public void scheduleAppointment(int patientId, int doctorId, LocalDateTime appointmentDateTime) {
        if (!patients.containsKey(patientId)) {
            System.out.println("Patient not found.");
            return;
        }
        if (!doctors.containsKey(doctorId)) {
            System.out.println("Doctor not found.");
            return;
        }

        // Check for appointment conflicts
        for (Appointment appointment : appointments) {
            if (appointment.getDoctorId() == doctorId && appointment.getAppointmentDateTime().equals(appointmentDateTime)) {
                System.out.println("This time slot is already booked for the doctor.");
                return;
            }
        }

        appointments.add(new Appointment(appointmentCounter++, patientId, doctorId, appointmentDateTime));
        System.out.println("Appointment scheduled successfully.");
    }

    
   
}
