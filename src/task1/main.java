package task1;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        int choice=0;
        

        Scanner mainScanner = new Scanner(System.in);
        taskManager manager = new taskManager(); // Instantiate TaskManager
        
        do {
            System.out.println("\n\n\n Choose one of the following options:");
            System.out.println("1. Add a task");
            System.out.println("2. View tasks ordered by due dates");
            System.out.println("3. Mark a task as completed");
            System.out.println("4. View history of completed tasks");
            System.out.println("5. View urgent tasks");
            System.out.println("6. Show tasks based on category");
            System.out.println("7. Exit");

            try {
                choice = mainScanner.nextInt();
                mainScanner.nextLine(); // Consume newline character

                switch (choice) {
                    case 1:
                        // Add a task
                        manager.addTask();
                        break;
                    case 2:
                        // View tasks ordered by due dates
                        manager.viewTasksByDueDate();
                        break;
                    case 3:
                        // Mark a task as completed
                        manager.markingCompleted();
                        break;
                    case 4:
                        // View history of completed tasks
                        manager.viewHistoryOfCompletedT();
                        break;
                    case 5:
                        // View urgent tasks
                        manager.viewUrgent();
                        break;
                    case 6:
                        // Show tasks based on category
                        manager.showTasksByCategory();
                        break;
                    case 7:
                        System.out.println(" SYSTEM EXIT !");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
                
                
                //ERROR HANDLE : USER NOT PUTTING NUMBERS
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                mainScanner.nextLine(); //moving the scanner to the next line to accept 
            }
        } while (choice != 7);

        mainScanner.close(); // Close the Scanner object ( SOURCES ARE ALWAYS HAVE TO BE CLOSED TO AVOID ERRORS) 
    }
}
