import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
     public static void main(String[] args) {
        ClinicManagementSystem system = new ClinicManagementSystem();
        Scanner scanner = new Scanner(System.in);

        // Sample interaction with the system
        try {
            while (true) {
                System.out.println("\nClinic Management System Menu:");
                System.out.println("1. Add Patient");
                System.out.println("2. Remove Patient");
                System.out.println("3. Update Patient");
                System.out.println("4. Add Doctor");
                System.out.println("5. Remove Doctor");
                System.out.println("6. Update Doctor");
                System.out.println("7. Schedule Appointment");
                System.out.println("8. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Patient ID: ");
                        int patientId = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        System.out.print("Enter Patient Name: ");
                        String patientName = scanner.nextLine();
                        System.out.print("Enter Contact Number: ");
                        String contactNumber = scanner.nextLine();
                        System.out.print("Enter Medical History: ");
                        String medicalHistory = scanner.nextLine();
                        system.addPatient(new Patient(patientId, patientName, contactNumber, medicalHistory));
                        break;

                    case 2:
                        System.out.print("Enter Patient ID to Remove: ");
                        patientId = scanner.nextInt();
                        system.removePatient(patientId);
                        break;

                    case 3:
                        System.out.print("Enter Patient ID to Update: ");
                        patientId = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        System.out.print("Enter Updated Patient Name: ");
                        patientName = scanner.nextLine();
                        System.out.print("Enter Updated Contact Number: ");
                        contactNumber = scanner.nextLine();
                        System.out.print("Enter Updated Medical History: ");
                        medicalHistory = scanner.nextLine();
                        system.updatePatient(patientId, new Patient(patientId, patientName, contactNumber, medicalHistory));
                        break;

                    case 4:
                        System.out.print("Enter Doctor ID: ");
                        int doctorId = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        System.out.print("Enter Doctor Name: ");
                        String doctorName = scanner.nextLine();
                        System.out.print("Enter Specialization: ");
                        String specialization = scanner.nextLine();
                        System.out.print("Enter Contact Number: ");
                        contactNumber = scanner.nextLine();
                        system.addDoctor(new Doctor(doctorId, doctorName, specialization, contactNumber));
                        break;

                    case 5:
                        System.out.print("Enter Doctor ID to Remove: ");
                        doctorId = scanner.nextInt();
                        system.removeDoctor(doctorId);
                        break;

                    case 6:
                        System.out.print("Enter Doctor ID to Update: ");
                        doctorId = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        System.out.print("Enter Updated Doctor Name: ");
                        doctorName = scanner.nextLine();
                        System.out.print("Enter Updated Specialization: ");
                        specialization = scanner.nextLine();
                        System.out.print("Enter Updated Contact Number: ");
                        contactNumber = scanner.nextLine();
                        system.updateDoctor(doctorId, new Doctor(doctorId, doctorName, specialization, contactNumber));
                        break;

                    case 7:
                        System.out.print("Enter Patient ID: ");
                        patientId = scanner.nextInt();
                        System.out.print("Enter Doctor ID: ");
                        doctorId = scanner.nextInt();
                        System.out.print("Enter Appointment Date and Time (yyyy-MM-ddTHH:mm): ");
                        scanner.nextLine();  // Consume newline
                        String dateTimeInput = scanner.nextLine();
                        LocalDateTime appointmentDateTime = LocalDateTime.parse(dateTimeInput);
                        system.scheduleAppointment(patientId, doctorId, appointmentDateTime);
                        break;

                    case 8:
                        System.out.println("Exiting the system. Goodbye!");
                        return;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter correct data types.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
