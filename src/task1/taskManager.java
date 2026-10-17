package task1;

import java.util.Scanner;

import task1.LinkedList.node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;

public class taskManager {

	static LinkedList tasksList = new LinkedList();

	static Scanner scanner = new Scanner(System.in);
    static Queue completedTasks = new Queue();
	static Stack urgentTasksStack = new Stack();
    static HashMap<String, LinkedList> tasksByCategory = new HashMap<>();


    

	// 1.
	public static void addTask() {
		System.out.println("Enter task details:");
		System.out.print("Name: ");
		try {
		String Tname = scanner.nextLine();

		System.out.println("Enter due date:");
		System.out.print("Enter day: ");
		int Tday = scanner.nextInt();

		System.out.print("Enter month: ");
		int Tmonth = scanner.nextInt();

		System.out.print("Enter year: ");
		int Tyear = scanner.nextInt();
	    scanner.nextLine();
	    
	    
	    
		System.out.print("Priority (urgent or normal): ");
		//ERROR HANDEL :
		String Tpriority = scanner.nextLine().toLowerCase();
		
		
		//ERROR HANDEL :
		  if (!Tpriority.equals("urgent") && !Tpriority.equals("normal")) {
	            throw new IllegalArgumentException("Priority must be either 'urgent' or 'normal'");
	       }

		System.out.print("Category: ");
		String Tcategory = scanner.nextLine();

		task ADDEDtask = new task(Tname, Tday, Tmonth, Tyear, Tpriority, Tcategory);
		tasksList.insertLast(ADDEDtask); 
	

		System.out.println("Task added !");
		
		//ERROR HABDLE :
		   } catch (InputMismatchException e) {// IF I AM ACCEPTING INTEGERS
		        System.out.println("Invalid input. Please enter a valid number.");
		        scanner.nextLine(); 
		    } catch (IllegalArgumentException e) {// THE PRIORTY CASE ABOVE
		        System.out.println("Invalid priority input. Priority must be either 'urgent' or 'normal'.");
		    } catch (Exception e) {//ANY UNEXPECTED , IT IS THE LAST ONE TO BETHE LAST CHOICE 
		        System.out.println("An unexpected error occurred: " + e.getMessage());
		    }
	}

	 //2.
	static void viewTasksByDueDate() {
	    if (tasksList.isEmpty()) {
	        System.out.println("No tasks found.");
	        return;
	    }

	    tasksList.head = Sort.sortingProcess(tasksList.head);

	    System.out.println("Tasks ordered by due dates:");
	    
	    
	    
	    // this is just printing.
	    node printingCurrent = tasksList.head;
	    while (printingCurrent != null) {
	        task t = printingCurrent.data;
	        System.out.println(t.getName()+t.getDueDate());
	        printingCurrent = printingCurrent.next;
	    }
	}
	
	
	
	
	
	// 3.QUEUE

	// this function is just for adding to the list and thier ia another function to
	// view them
	public static void markingCompleted() {
		System.out.println("Please enter the name of the task to mark it as completed:");
		String CompletedTasK = scanner.nextLine();
		try {
		node currentTask = tasksList.head;
		node previousTask = null; // no previose at the strat
		// previose needed to be able to remove frmo that lust

		while (currentTask != null) {// this is the travisring into the linked list

			// the data dattype is task so it has the get name getter
			if (currentTask.data.getName().equalsIgnoreCase(CompletedTasK)) {
				currentTask.data.setCompleted(true); // setter attribute

				completedTasks.enqueue(currentTask.data);  
		

				if (previousTask == null) {// if ti is the head
					tasksList.removeFirst();
				} else {

					// the .next of the previose was liking the the current
					// now i want to remove the current so let it link to the next of it
					previousTask.next = currentTask.next;
					///removing from the original list
				}
				System.out.println(" well done ! your task marked as completed ");
				return;
			}
			// travirsing
			previousTask = currentTask;
			currentTask = currentTask.next;
		}
		System.out.println("Task not found "); // add a case for the already completed
	
	} catch (Exception e) {
        System.out.println("An unexpected error occurred: " + e.getMessage());
	}
}

	// 4.
	public static void viewHistoryOfCompletedT() {
		if (completedTasks.isEmpty()) {
			System.out.println("No completed tasks found.");
			return;
		}

		System.out.println("History of completed tasks:");


		 while (!completedTasks.isEmpty()) {
	            task completedTask = completedTasks.dequeue();
	            System.out.println(completedTask.getName());
		 }
	}

	// 5.

	public static void viewUrgent() {// STACK !

		node currentNode = tasksList.head;
		// Start from the head of the tasks list

		// the process of adding the urgent to a new liat

		while (currentNode != null) {
			task currentTask = currentNode.data;
			if (currentTask.getPriority().equalsIgnoreCase("urgent")) {
				urgentTasksStack.push(currentTask);
			

			}
	        currentNode = currentNode.next; // Update currentNode to move to the next node

		}

		// viewing:

		if (urgentTasksStack.isEmpty()) {
			System.out.println("No urgent tasks found.");
			return;
		}

		System.out.println("Urgent tasks U have :");

		while (urgentTasksStack.isEmpty() == false) {
			task urgentTask = urgentTasksStack.pop(); // Pop the topmost task from the stack
			System.out.println(urgentTask.getName());
		}

	}

	// 6.

	// a hashmap to link key ( cat name ) to a list that have the lists belong to it

	public static void showTasksByCategory() {
		
		dividingTasksByCategory();
	    List<String> categories = new ArrayList<>(tasksByCategory.keySet());

	    Collections.sort(categories);
	    for (String category : categories) {
	        char firstLetter = category.charAt(0);
	        if ((firstLetter >= 'a' && firstLetter <= 'z') || (firstLetter >= 'A' && firstLetter <= 'Z')) {
	            System.out.println("\nCategory: " + category);

	            // Get the tasks list for the current category
	            LinkedList tasksList = tasksByCategory.get(category);
	            if (tasksList != null) {
	                // Get the head of the linked list
	                node current = tasksList.head;

	                // Traverse the linked list and print task names
	                while (current != null) {
	                    task currentTask = current.data;
	                    System.out.println(currentTask.getName());
	                    current = current.next; // Move to the next node
	                }
	            }
	        }
	    }

	}

	public static void dividingTasksByCategory() {
	    tasksByCategory.clear();

		// this is just for preparing the keys ( all of them ) and relate them to a
		// linked list ( value)
		node current = tasksList.head;
		while (current != null) {
			task task = current.data;
			String category = task.getCategory();

			// this function is to see if the cat is already exsists as a key
			if (tasksByCategory.containsKey(category) == false) {

				// this function take the catigory that is not added && the value which is the
				// linked list .
				tasksByCategory.put(category, new LinkedList());
			}

			// . get -> retrieves the value linked to given key ( so here it is retrieving
			// the value ( list )
			// then i can add tasks to it
			tasksByCategory.get(category).insertLast(task);
            current = current.next;

		}

	}
	
	


}
