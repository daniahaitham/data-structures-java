package task1;

import task1.LinkedList.node;

public class LinkedList {

	

	class node {

		task data;
		node next;// this is becouse every node is holding the reference of the next ( this is the way of linking)

		node(task data) {

			this.data = data;
			next = null;
		}

	}
	
	 node head; // pointer its datattype is a node becouse it refairs to the first elemnt which is a node 
	
	public void insertLast(task data) { // O(1)

		node x = new node(data); //its datatype is a node becouse it iterates on nodes

		if (head == null) {//create the head if not exisit
			head = x;
		} else {

			node i = head;
			while (i.next != null) {//this is used to reach the final node then add to its next

				i = i.next;
			}

			i.next = x;

		}

	}
	
	public void insertFirst(task data) { // I DIDNOT USE THAT !!
		node x = new node(data);

		x.next = head;
		head = x;//to make the node refare to the next 

	}
	
	
	public void removeLast() {// I DIDNOT USE THAT !!!
		if (head == null) {
			return; // if is empty

		}
		if (head.next == null) {

			head = null; // if one element

		} else {

			node i = head;

			while (i.next.next != null) {

				i = i.next;//moving i to point to the next until it reach the second last elemnt

			}

			i.next = null; //make that second last  next to be null

		}

	}
	
	
	public task removeFirst() {//O(1)

		node removedNode = head; // save the address of the removed node before i destroy it
		head = head.next;
		removedNode.next = null;
		return removedNode.data;

	}
	
	
    
	

	public void print() {
		node i = head;
		System.out.print("[");
		while (i != null) {

			System.out.print(i.data + ",");
			i = i.next;
		}
		System.out.println("]");
	}
	
	
	 public boolean isEmpty() {
	        return head == null;
	    }

	public int size() {
		int count = 0;
	    node current = head;
	    while (current != null) {
	        count++;
	        current = current.next;
	    }
	    return count;
	}
	
}
