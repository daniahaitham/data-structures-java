package task1;

public class Queue extends LinkedList {

	public void enqueue(task data) {
		insertLast(data);

	}

	public task dequeue() {
		return removeFirst();
	}

	public task Top() {
		return head.data;
	}

}
