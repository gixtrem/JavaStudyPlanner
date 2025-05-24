// Import statements allow using pre-built Java classes from standard Java libraries.
import java.util.ArrayList; // For creating and managing dynamic arrays (lists)
import java.util.List;      // Interface for a list data structure
import java.util.Scanner;   // To read user input from the command line

// Main class, serves as the entry point for your Java application.
public class Main {

    /**
     * main method is the entry point for all Java applications.
     * Execution begins from this method.
     */
    public static void main(String[] args) {
        // Create a dynamic list to store schedule entries.
        List<Schedule> schedules = new ArrayList<>();

        // Scanner instance to capture user input from the command line.
        Scanner scanner = new Scanner(System.in);

        // Display a welcome message when the program starts.
        System.out.println("\n Welcome to the Student Study Planner ");

        // Boolean variable to control the loop (true means the loop continues).
        boolean running = true;

        // Main loop that displays menu options and takes user actions repeatedly until exited.
        while (running) {
            // Show the command-line menu options clearly to the user.
            System.out.println("\nPlease choose an option:");
            System.out.println("1.  Add a Study Schedule");
            System.out.println("2.  View All Schedules");
            System.out.println("3.  Export Schedules to CSV");
            System.out.println("4.  Exit");
            System.out.print("Your choice: ");

            int choice;

            // Using try-catch block to handle cases where the user input isn't an integer.
            try {
                // Reads user input as a String, then converts it to an integer.
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                // If input can't be converted to integer, prompt user to try again.
                System.out.println(" Invalid input! Please enter a number.");
                continue; // skips to the next loop iteration
            }

            // Switch-case statement to perform actions based on user's menu selection.
            switch (choice) {
                case 1:
                    // Calls helper method to add a new schedule.
                    addSchedule(scanner, schedules);
                    break;

                case 2:
                    // Calls helper method to display all stored schedules.
                    viewSchedules(schedules);
                    break;

                case 3:
                    // Calls the exporter class method to save schedules to a CSV file.
                    ScheduleExporter.exportToCSV(schedules, "schedules/exported_schedule.csv");
                    break;

                case 4:
                    // Set running to false to exit the loop and terminate the program.
                    running = false;
                    System.out.println(" Exiting... Good luck studying!");
                    break;

                default:
                    // Default case handles input that doesn't match any menu options.
                    System.out.println(" Invalid option. Please choose again.");
            }
        }

        // Close the Scanner resource to prevent memory leaks.
        scanner.close();
    }

    /**
     * Helper method to add a schedule by prompting user input.
     * @param scanner Scanner object for reading user input
     * @param schedules List that stores schedule entries
     */
    private static void addSchedule(Scanner scanner, List<Schedule> schedules) {
        // Prompt the user for the subject of the study session.
        System.out.print("\nEnter Subject: ");
        String subject = scanner.nextLine();

        // Prompt user for the date of the study session.
        System.out.print("Enter Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        // Prompt user for the time of the study session.
        System.out.print("Enter Time (HH:MM): ");
        String time = scanner.nextLine();

        // Prompt user for additional notes about the study session.
        System.out.print("Additional Notes: ");
        String notes = scanner.nextLine();

        // Create a new Schedule object with the input provided and add it to the list.
        schedules.add(new Schedule(subject, date, time, notes));

        // Confirm successful addition of the schedule.
        System.out.println("Schedule successfully added!");
    }

    /**
     * Helper method to display all stored schedules in a readable format.
     * @param schedules List that stores schedule entries
     */
    private static void viewSchedules(List<Schedule> schedules) {
        // Display a heading for clarity when schedules are printed.
        System.out.println("\n  Your Current Study Schedules ");

        // Check if there are any schedules in the list.
        if (schedules.isEmpty()) {
            // If list is empty, inform user clearly.
            System.out.println("No schedules found! Why not add one?");
        } else {
            // If schedules exist, iterate and print each one.
            for (int i = 0; i < schedules.size(); i++) {
                // Retrieve each schedule object.
                Schedule s = schedules.get(i);

                // Print schedule details in an organized manner.
                System.out.printf("%d. %s | %s | %s | %s\n", 
                    (i + 1), s.getSubject(), s.getDate(), s.getTime(), s.getNotes());
            }
        }
    }
}
