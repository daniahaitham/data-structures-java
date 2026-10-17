package task1;

public class Stack extends LinkedList {

	public void push(task data) {
		insertFirst(data);
	}

	public task pop() {
		return removeFirst();
	}

	public task peek() {
		return head.data;
	}

}
