package task1;

import task1.LinkedList.node;

public class Sort {

    public static node sortingProcess(node head) {
        if (head.next == null) {
            return head;
        }

        boolean swapped;//to indicate of a swapp is happpining in each iteration.
       node current; // this is a pointer to move into all the list

        
        
        
        do {
            swapped = false;// in each iteration we reset the swap to false becouse in each iteration i want to check is thier swapping or not.
            current = head; // strating from head.

            while (current.next != null) {
                if (isLaterDueDate(current.data, current.next.data)) {
                    swap(current, current.next);
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
// until no swapps are happining.
        
        // this will return the head then i can reach the orderd list.
        return head;
    }

    private static void swap(node node1,node node2) {
        task temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;
    }

    // Checks if task1 has a later due date than task2
    static boolean isLaterDueDate(task task1, task task2) {
        int year1 = task1.getYear();
        int month1 = task1.getMonth();
        int day1 = task1.getDay();

        int year2 = task2.getYear();
        int month2 = task2.getMonth();
        int day2 = task2.getDay();

        if (year1 > year2 || (year1 == year2 && month1 > month2) || (year1 == year2 && month1 == month2 && day1 > day2)) {
            return true;
        }
        return false;
    }
}
