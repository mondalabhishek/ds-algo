package com.practice.ds.linkedlist;

import java.util.function.Consumer;

/**
 * Implementaion of One way linked list
 * @author Abhishek Mondal
 *
 */
public class MyLinkedList {

	// Current Head
	private Node head = null;

	// Current Tail
	private Node tail = null;

	private int length;

	public class Node {
		// Value of Node
		String value;

		// Next Node of a Node
		Node next = null;

		public Node(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
		
		public Node() {
			
		}
	}

	// Inititalize Linked List
	public MyLinkedList(String value) {
		Node node = new Node(value);
		this.head = node;
		this.tail = node;
		length++;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public MyLinkedList() {

	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	// Append a new Node
	public void append(String value) {
		Node node = new Node();
		node.setValue(value);
		this.getTail().setNext(node);
		this.setTail(node);
		length++;
	}

	// Prepend a new Node
	public void prepend(String value) {
		Node node = new Node();
		node.setValue(value);
		node.setNext(this.getHead());
		this.setHead(node);
		length++;
	}

	// Insert a new node at a target index
	public void insert(String value, int idx) {
		if (idx == 0) {
			prepend(value);
		} else if (length > 1 && idx < length) {
			Node newNode = new Node();
			newNode.setValue(value);

			Node item = this.getHead();
			int count = 1;
			while (item != null) {
				if (count == idx) {
					newNode.setNext(item.getNext());
					item.setNext(newNode);
					length++;
					break;
				}
				item = item.getNext();
				count++;
			}

		} else {
			throw new RuntimeException("Index not found");
		}
	}

	// Remove item at target index
	public void remove(int idx) {
		Node item = this.getHead();
		if (idx == 0) {
			this.setHead(item.getNext());
			length--;
			return;
		}
		int count = 1;
		while (item != null && count < length) {
			if (count == idx) {
				if (item.getNext().getNext() == null) {
					this.setTail(item);
				}
				item.setNext(item.getNext().getNext());
				length--;
				break;
			}
			item = item.getNext();
			count++;
		}
	}

	//TODO: Bad solution!! Refactor!!!!
	public void reverse() {
		for (int i = 0; i < length; i++) {
			String value = this.getHead().getValue();
			if (length - i == length) {
				append(value);
			} else {
				this.insert(value, length - i);
			}
			this.remove(0);
		}
	}

	private static Consumer<MyLinkedList> printLinkedList = myLinkedList -> {
		System.out.println("Length of the Linked List: " + myLinkedList.length);

		System.out.println("Printing List Items:");

		MyLinkedList.Node item = myLinkedList.getHead();
		System.out.print(item.getValue());
		while (item.getNext() != null) {
			item = item.getNext();
			System.out.print(" >> " + item.getValue());
		}
		System.out.print(" \n\n");
	};

	public static void main(String[] args) {
		MyLinkedList myLinkedList = new MyLinkedList("10");
		myLinkedList.append("11");
		myLinkedList.prepend("9");
		myLinkedList.prepend("5");
		myLinkedList.append("15");
		printLinkedList.accept(myLinkedList);

		System.out.println("Inserting 1@3");
		myLinkedList.insert("1", 3);
		printLinkedList.accept(myLinkedList);

		System.out.println("Removing @5");
		myLinkedList.remove(5);
		printLinkedList.accept(myLinkedList);

		System.out.println("Reversing");
		myLinkedList.reverse();
		printLinkedList.accept(myLinkedList);
	}

}
